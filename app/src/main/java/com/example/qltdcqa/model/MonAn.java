package com.example.qltdcqa.model;

public class MonAn {
    private int maMon;

    private String tenMon;

    private int giaDat;

    private int thoiGianLamMon;

    public MonAn() {
    }

    public String toString(){
        return "Món ăn{" + " mã món = " + maMon + ", tên món = " + tenMon + '\'' + ", giá đặt = " + giaDat + '\'' + ", thời gian làm món = " + thoiGianLamMon + '}';
    }

    public MonAn(int maMon, String tenMon, int giaDat, int thoiGianPhucVu) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.giaDat = giaDat;
        this.thoiGianLamMon = thoiGianPhucVu;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGiaDat() {
        return giaDat;
    }

    public void setGiaDat(int giaDat) {
        this.giaDat = giaDat;
    }

    public int getThoiGianLamMon() {
        return thoiGianLamMon;
    }

    public void setThoiGianLamMon(int thoiGianLamMon) {
        this.thoiGianLamMon = thoiGianLamMon;
    }
}
