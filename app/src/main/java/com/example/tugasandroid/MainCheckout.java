package com.example.tugasandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.tugasandroid.Adapter.AdapterCheckout;
import com.example.tugasandroid.Adapter.AdapterTransaksi;
import com.example.tugasandroid.DataBase.DBHelper;
import com.example.tugasandroid.Model.ModelDataBarang;

import java.util.ArrayList;
import java.util.List;

public class MainCheckout extends AppCompatActivity {

    private AdapterCheckout adapterCheckout;
    private List<ModelDataBarang> barangList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DBHelper db;
    private Button btncancel, btnsubmit, btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_checkout);

        recyclerView = findViewById(R.id.listcheckout);
        btncancel = findViewById(R.id.btncancel);
        btnsave = findViewById(R.id.btnsaveorder);
        btnsubmit = findViewById(R.id.btnsubmit);

        DBHelper dbh = new DBHelper(this);
        dbh.getWritableDatabase();

        db = new DBHelper(this);
        barangList.addAll(db.getAllRecord());

        adapterCheckout = new AdapterCheckout(this, barangList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterCheckout);


    }
}