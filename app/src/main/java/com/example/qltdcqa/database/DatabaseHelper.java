package com.example.qltdcqa.database;

import android.content.Context;

import com.example.qltdcqa.model.LoaiMon;
import com.example.qltdcqa.model.LoaiMonAn;
import com.example.qltdcqa.model.MonAn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.SharedPreferences;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private Gson gson;

    private static String NAME_DATA_BASE = "NAME_DATA_BASE";
    private static String KEY_MON_AN = "KEY_MON_AN";
    private static String KEY_LOAI_MON = "KEY_LOAI_MON";
    private static String KEY_LOAI_MON_AN = "KEY_LOAI_MON_AN";

    public DatabaseHelper(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(NAME_DATA_BASE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
    }

    /**
     * monAn
     */

    public List<MonAn> layMonAn() {
        List<MonAn> maList = new ArrayList<>();
        String maShare = sharedPreferences.getString(KEY_MON_AN, "");
        Type maType = new TypeToken<ArrayList<MonAn>>() {
        }.getType();
        maList = gson.fromJson(maShare, maType);
        if (maList == null) {
            maList = new ArrayList<>();
        }
        return maList;
    }

    public List<MonAn> layDSLietKe() {
        List<MonAn> maList = new ArrayList<>();
        String maShare = sharedPreferences.getString(KEY_MON_AN, "");
        Type maType = new TypeToken<ArrayList<MonAn>>() {
        }.getType();
        maList = gson.fromJson(maShare, maType);
        List<MonAn> maList2 = new ArrayList<>();
        for (int i = 0; i < maList.size(); i++) {
            if (maList.get(i).getGiaDat() == 200 && maList.get(i).getThoiGianLamMon() < 15) {
                maList2.add(maList.get(i));
            }
        }
        return maList2;
    }

    public void themMonAn(MonAn monAn) {
        List<MonAn> monAns = layMonAn();
        if (monAns == null) {
            monAns = new ArrayList<>();
            monAn.setMaMon(1);
        } else {
            monAn.setMaMon(monAns.size() + 1);
        }
        monAns.add(monAn);
        String ma = gson.toJson(monAns);
        editor.putString(KEY_MON_AN, ma);
        editor.commit();
    }

    public List<Integer> layDSIdMonAn() {
        List<Integer> idMAList = new ArrayList<>();
        List<MonAn> monAnList = layMonAn();
        for (MonAn monAn : monAnList) {
            int idMA = monAn.getMaMon();
            idMAList.add(idMA);
        }
        return idMAList;
    }

    /**
     * loaiMon
     */

    public List<LoaiMon> layLoaiMon() {
        List<LoaiMon> loaiList = new ArrayList<>();
        String loaiShare = sharedPreferences.getString(KEY_LOAI_MON, "");
        Type loaiType = new TypeToken<ArrayList<LoaiMon>>() {
        }.getType();
        loaiList = gson.fromJson(loaiShare, loaiType);
        if (loaiList == null) {
            loaiList = new ArrayList<>();
        }
        return loaiList;
    }

    public void themLoaiMon(LoaiMon loaiMon) {
        List<LoaiMon> loaiMons = layLoaiMon();
        if (loaiMons == null) {
            loaiMons = new ArrayList<>();
            loaiMon.setMaLoai(1);
        } else {
            loaiMon.setMaLoai(loaiMons.size() + 1);
        }
        loaiMons.add(loaiMon);
        String ma = gson.toJson(loaiMons);
        editor.putString(KEY_LOAI_MON, ma);
        editor.commit();
    }

    public List<Integer> layDSIdLoaiMon() {
        List<Integer> idLMList = new ArrayList<>();
        List<LoaiMon> loaiMonList = layLoaiMon();
        for (LoaiMon loaiMon : loaiMonList) {
            int idLoaiMon = loaiMon.getMaLoai();
            idLMList.add(idLoaiMon);
        }
        return idLMList;
    }

    /**
     * loaiMonAn
     */

    public List<LoaiMonAn> layLoaiMonAn() {
        List<LoaiMonAn> loaiMonAns = new ArrayList<>();
        String loaiMAShare = sharedPreferences.getString(KEY_LOAI_MON_AN, "");
        Type loaiMAType = new TypeToken<ArrayList<LoaiMonAn>>() {
        }.getType();
        loaiMonAns = gson.fromJson(loaiMAShare, loaiMAType);
        if (loaiMonAns == null) {
            loaiMonAns = new ArrayList<>();
        }
        return loaiMonAns;
    }

    public void themLoaiMonAn(LoaiMonAn loaiMon) {
        List<LoaiMonAn> loaiMonAns = layLoaiMonAn();
        if (loaiMonAns == null) {
            loaiMonAns = new ArrayList<>();
            loaiMon.setIdMonAn(1);
            loaiMon.setIdLoaiMon(1);
        } else {
            loaiMon.setIdLoaiMon(loaiMonAns.size() + 1);
            loaiMon.setIdMonAn(loaiMonAns.size() + 1);
        }
        loaiMonAns.add(loaiMon);
        String lma = gson.toJson(loaiMonAns);
        editor.putString(KEY_LOAI_MON_AN, lma);
        editor.commit();
    }
}
