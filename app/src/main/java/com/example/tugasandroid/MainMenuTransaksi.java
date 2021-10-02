package com.example.tugasandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tugasandroid.Adapter.AdapterBarang;
import com.example.tugasandroid.Adapter.AdapterTransaksi;
import com.example.tugasandroid.DataBase.DBHelper;
import com.example.tugasandroid.Model.ModelDataBarang;

import java.util.ArrayList;
import java.util.List;

public class MainMenuTransaksi extends AppCompatActivity {

    private AdapterTransaksi adapterTransaksi;
    private List<ModelDataBarang> barangList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DBHelper db;
    private Button btncheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_transaksi);

        recyclerView = findViewById(R.id.listTransaksi);
        btncheckout = findViewById(R.id.btnCheckout);

        DBHelper dbh = new DBHelper(this);
        dbh.getWritableDatabase();

        db = new DBHelper(this);
        barangList.addAll(db.getAllRecord());

        adapterTransaksi = new AdapterTransaksi(this, barangList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterTransaksi);

        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuTransaksi.this, MainCheckout.class);
                startActivity(intent);
            }
        });
    }
}