package com.example.tugasandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tugasandroid.Adapter.AdapterBarang;
import com.example.tugasandroid.DataBase.DBHelper;
import com.example.tugasandroid.Model.ModelDataBarang;

import java.util.ArrayList;
import java.util.List;

public class MainMenuBarang extends AppCompatActivity {

    private Button addBarang;
    private AdapterBarang adapterBarang;
    private List<ModelDataBarang> barangList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DBHelper dbHelper;

    String namaBarang;
    String kodeBarang;
    int stokBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_barang);

        addBarang = findViewById(R.id.btnTambahBarang);
        recyclerView = findViewById(R.id.listBarang);

        DBHelper dbh = new DBHelper(this);
        dbh.getWritableDatabase();

        dbHelper = new DBHelper(this);
        barangList.addAll(dbHelper.getAllRecord());

        adapterBarang = new AdapterBarang(this, barangList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapterBarang);

        addBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainMenuBarang.this);
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
                        namaBarang = etnamabarang.getText().toString();
                        kodeBarang = etkodebarang.getText().toString();
                        stokBarang = Integer.parseInt(etstokbarang.getText().toString());

                        ModelDataBarang modelDataBarang = new ModelDataBarang(kodeBarang, namaBarang, stokBarang);
                        DBHelper db = new DBHelper(getApplicationContext());

                        if (db.addRecord(modelDataBarang) == 1){
                            Toast.makeText(MainMenuBarang.this, "Data tersimpan", Toast.LENGTH_SHORT).show();
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
    }
}