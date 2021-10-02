package com.example.tugasandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasandroid.Model.ModelDataBarang;
import com.example.tugasandroid.R;

import java.util.List;

public class AdapterTransaksi extends RecyclerView.Adapter<AdapterTransaksi.MyViewHolder> {

    private List<ModelDataBarang> modelDataBarangs;
    private Context context;

    public AdapterTransaksi(Context context,List<ModelDataBarang> modelDataBarangs){
        this.modelDataBarangs = modelDataBarangs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaksi,parent,false);
        return new AdapterTransaksi.MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelDataBarang modelDataBarang = modelDataBarangs.get(position);

        holder.nmbarangT.setText(modelDataBarang.getNamabarang());
        holder.kodebarangT.setText(modelDataBarang.getKodebarang());
        holder.btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelDataBarangs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nmbarangT, kodebarangT, jumlahbarangT;
        Button btnadd;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nmbarangT = itemView.findViewById(R.id.nmitembarangtransaksi);
            kodebarangT = itemView.findViewById(R.id.iditembarangtransaksi);
            jumlahbarangT = itemView.findViewById(R.id.jumlahitembarangtransaksi);
            btnadd = itemView.findViewById(R.id.addtocart);
        }
    }
}
