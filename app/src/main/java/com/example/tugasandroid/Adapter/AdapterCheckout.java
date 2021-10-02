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

public class AdapterCheckout extends RecyclerView.Adapter<AdapterCheckout.MyViewHolder> {

    private List<ModelDataBarang> modelDataBarangs;
    private Context context;

    public AdapterCheckout(Context context,List<ModelDataBarang> modelDataBarangs){
        this.modelDataBarangs = modelDataBarangs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checkout,parent,false);
        return new AdapterCheckout.MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelDataBarang modelDataBarang = modelDataBarangs.get(position);

        holder.nmbarangC.setText(modelDataBarang.getNamabarang());
        holder.kodebarangC.setText(modelDataBarang.getKodebarang());
        holder.jumlahbarangC.setText(String.valueOf(modelDataBarang.getJumlahbarang()));
        holder.btnremove.setOnClickListener(new View.OnClickListener() {
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

        TextView nmbarangC, kodebarangC, jumlahbarangC;
        Button btnremove;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nmbarangC = itemView.findViewById(R.id.nmitembarangc);
            kodebarangC = itemView.findViewById(R.id.iditembarangc);
            jumlahbarangC = itemView.findViewById(R.id.jumlahbarangc);
            btnremove = itemView.findViewById(R.id.btnitemhapus);
        }
    }
}
