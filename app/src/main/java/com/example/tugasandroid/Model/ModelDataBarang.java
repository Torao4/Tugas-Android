package com.example.tugasandroid.Model;

public class ModelDataBarang {

    private String kodebarang;
    private String namabarang;
    private int stokbarang;
    private int jumlahbarang;

    public ModelDataBarang(String kodebarang, String namabarang, int stokbarang) {
        this.kodebarang = kodebarang;
        this.namabarang = namabarang;
        this.stokbarang = stokbarang;
    }

    public ModelDataBarang(String kodebarang, String namabarang, int stokbarang, int jumlahbarang) {
        this.kodebarang = kodebarang;
        this.namabarang = namabarang;
        this.stokbarang = stokbarang;
        this.jumlahbarang = jumlahbarang;
    }

    public String getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(String kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public int getStokbarang() {
        return stokbarang;
    }

    public void setStokbarang(int stokbarang) {
        this.stokbarang = stokbarang;
    }

    public int getJumlahbarang() {
        return jumlahbarang;
    }

    public void setJumlahbarang(int jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }
}
