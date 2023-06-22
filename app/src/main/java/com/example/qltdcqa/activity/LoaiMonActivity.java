package com.example.qltdcqa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qltdcqa.R;
import com.example.qltdcqa.database.DatabaseHelper;
import com.example.qltdcqa.model.LoaiMon;

import java.util.ArrayList;
import java.util.List;

public class LoaiMonActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    Spinner spTenLoai;

    ListView lvLoaiMon;

    List<LoaiMon> loaiMons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_mon);

        databaseHelper = new DatabaseHelper(this);

        EditText edt = findViewById(R.id.edtMoTa);
        Button btnThemLoaiMon = findViewById(R.id.btnThemLoai);
        lvLoaiMon = findViewById(R.id.lvLoaiMon);
        spTenLoai = findViewById(R.id.spTenLoai);

        setupSpinner();

        btnThemLoaiMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiMon loaiMon = new LoaiMon();
                loaiMon.setTenLoai(spTenLoai.getSelectedItem().toString());
                loaiMon.setMoTa(edt.getText().toString());
                themLoaiMon(loaiMon);
                spTenLoai.setSelection(1);
                edt.setText("");
            }
        });
    }

    public void setupSpinner() {
        List<String> tenLoaiMonList = new ArrayList<>();
        tenLoaiMonList.add("món Tráng miệng");
        tenLoaiMonList.add("món Khai vị");
        tenLoaiMonList.add("món Chính");
        tenLoaiMonList.add("món Chay");
        tenLoaiMonList.add("món Chuyên bò");
        tenLoaiMonList.add("món Chuyên gà");
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tenLoaiMonList);
        spTenLoai.setAdapter(stringArrayAdapter);
    }

    public void setupListView() {
        loaiMons = databaseHelper.layDSLoaiMon();
        ArrayAdapter<LoaiMon> loaiMonArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , loaiMons);
        lvLoaiMon.setAdapter(loaiMonArrayAdapter);
    }

    public void themLoaiMon(LoaiMon loaiMon) {
        databaseHelper.themLoaiMon(loaiMon);
        setupListView();
    }
}
