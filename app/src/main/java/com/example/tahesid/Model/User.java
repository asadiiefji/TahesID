package com.example.tahesid.Model;

public class User {
    int berat,tinggi,lebih_berat,ideal,lebih_ringan;

    public User(int berat, int tinggi, int lebih_berat, int ideal, int lebih_ringan) {
        this.berat = berat;
        this.tinggi = tinggi;
        this.lebih_berat = lebih_berat;
        this.ideal = ideal;
        this.lebih_ringan = lebih_ringan;
    }

    public User(){}

    public int getBerat() {
        return berat;
    }

    public int getTinggi() {
        return tinggi;
    }

    public int getLebih_berat() {
        return lebih_berat;
    }

    public int getIdeal() {
        return ideal;
    }

    public int getLebih_ringan() {
        return lebih_ringan;
    }
}
