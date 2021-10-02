package com.example.tugasandroid.Adapter;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasandroid.DataBase.DBHelper;
import com.example.tugasandroid.MainCheckout;
import com.example.tugasandroid.MainMenuBarang;
import com.example.tugasandroid.Model.ModelDataBarang;
import com.example.tugasandroid.R;

import java.util.List;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.MyViewHolder> {

    private List<ModelDataBarang> modelDataBarangs;
    private Context context;
    String id;
    DBHelper db = new DBHelper(context);

    public AdapterBarang(Context context,List<ModelDataBarang> modelDataBarangs){
        this.modelDataBarangs = modelDataBarangs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang,parent,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelDataBarang modelDataBarang = modelDataBarangs.get(position);

        holder.nmbarang.setText(modelDataBarang.getNamabarang());
        holder.kodebarang.setText(modelDataBarang.getKodebarang());
        holder.stokbarang.setText(String.valueOf(modelDataBarang.getStokbarang()));
        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.formbarang);
                dialog.setTitle("TAMBAH DATA BARANG");

                EditText etnamabarang = (EditText) dialog.findViewById(R.id.inputNamaBarang);
                EditText etstokbarang = (EditText) dialog.findViewById(R.id.inputStokBarang);
                EditText etkodebarang = (EditText) dialog.findViewById(R.id.inputKodeBarang);
                Button btnsimpan = (Button) dialog.findViewById(R.id.btnsimpan);
                Button btnbatal = (Button) dialog.findViewById(R.id.btnbatal);

                btnsimpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                        if (db.addRecord(modelDataBarang) == 1){
                            Toast.makeText(context, "Data Berhasil Diedit", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });

                btnbatal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
        holder.btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Apa anda ingin menghapus?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (db.hapus_barang(id) == 1){
                            Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).setNegativeButton("No", null).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelDataBarangs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nmbarang, kodebarang, stokbarang;
        Button btnedit, btnhapus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nmbarang = itemView.findViewById(R.id.nmitembarang);
            kodebarang = itemView.findViewById(R.id.iditembarang);
            stokbarang = itemView.findViewById(R.id.stokitembarang);
            btnedit = itemView.findViewById(R.id.btnitemedit);
            btnhapus = itemView.findViewById(R.id.btnitemhapus);
        }
    }
}
