package com.example.qltdcqa.model;

public class LoaiMonAn {
    private int idMonAn;
    private int idLoaiMon;

    public String moTaMA;

    public LoaiMonAn(){}

    public String toString() {
        return "Loại món ăn {" + "mã món = " + idMonAn + ", loại món = " + idLoaiMon + '\'' + ", mô tả món ăn = " + moTaMA + '\'' +'}';
    }

    public LoaiMonAn(int idMonAn, int idLoaiMon, String moTaMA) {
        this.idMonAn = idMonAn;
        this.idLoaiMon = idLoaiMon;
        this.moTaMA = moTaMA;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getIdLoaiMon() {
        return idLoaiMon;
    }

    public void setIdLoaiMon(int idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }

    public String getMoTaMA() {
        return moTaMA;
    }

    public void setMoTaMA(String moTaMA) {
        this.moTaMA = moTaMA;
    }
}
