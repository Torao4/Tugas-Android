package com.example.tugasandroid.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tugasandroid.Model.ModelDataBarang;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_barang";
    private static final String TABLE_NAME = "tb_barang";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+
                "kodebarang  varchar(50) primary key, "+
                "namabarang varhcar(225)," +
                "stokbarang int(225));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public int addRecord(ModelDataBarang modelDataBarang){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kodebarang", modelDataBarang.getKodebarang());
        values.put("namabarang", modelDataBarang.getNamabarang());
        values.put("stokbarang", modelDataBarang.getStokbarang());
        db.insert(TABLE_NAME, null, values);
        db.close();

        return 1;
    }

    public ArrayList<ModelDataBarang> getBarang(String id){
        ArrayList<ModelDataBarang> listBarang = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE kodebarang = '"+id+"'", null);
        int i = 0;
        if (cur.getCount() > 0) cur.moveToFirst();
        while (i < cur.getCount()){
            ModelDataBarang mdb = new ModelDataBarang(
                    cur.getString(cur.getColumnIndex("kodebarang")),
                    cur.getString(cur.getColumnIndex("namabarang")),
                    cur.getInt(cur.getColumnIndex("stokbarang"))
            );
            listBarang.add(mdb);
            cur.moveToNext();
            i++;
        }
        db.close();
        return listBarang;
    }

    public List<ModelDataBarang> getAllRecord(){
        List<ModelDataBarang> userList = new ArrayList<>();
        String getAllQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(getAllQuery, null);
        if(cursor.moveToFirst()){
            do {
               ModelDataBarang barangModel = new ModelDataBarang(
                        cursor.getString(cursor.getColumnIndex("kodebarang")),
                        cursor.getString(cursor.getColumnIndex("namabarang")),
                        cursor.getInt(cursor.getColumnIndex("stokbarang"))
                );
                userList.add(barangModel);
            }while (cursor.moveToNext());
        }
        db.close();
        return userList;
    }

    public int hapus_barang(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "kodebarang = '"+id+"'", null);
        db.close();

        return 1;
    }
}
