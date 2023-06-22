package com.example.qltdcqa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qltdcqa.R;
import com.example.qltdcqa.database.DatabaseHelper;
import com.example.qltdcqa.model.LoaiMonAn;

import java.util.ArrayList;
import java.util.List;

public class LoaiMonAnActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    Spinner spIdMA, spIdLM;

    ListView lvLMA;

    List<LoaiMonAn> loaiMonAns;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_mon_an);

        databaseHelper = new DatabaseHelper(this);

        EditText edt = findViewById(R.id.edtMoTaLMA);
        spIdLM = findViewById(R.id.spMaLoai);
        spIdMA = findViewById(R.id.spMaMon);
        lvLMA = findViewById(R.id.lvLMA);
        Button btnGan = findViewById(R.id.btnGan);

        setupSpinnerIdLM();
        setupSpinnerIdMA();

        btnGan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiMonAn loaiMonAn = new LoaiMonAn();
                loaiMonAn.setIdLoaiMon(Integer.parseInt(spIdLM.getSelectedItem().toString()));
                loaiMonAn.setIdMonAn(Integer.parseInt(spIdMA.getSelectedItem().toString()));
                loaiMonAn.setMoTaMA(edt.getText().toString());
                themLoaiMA(loaiMonAn);
                edt.setText("");
                spIdMA.setSelection(0);
                spIdLM.setSelection(0);
            }
        });
    }

    public void setupSpinnerIdLM() {
        List<Integer> integers = new ArrayList<>();
        integers = databaseHelper.layDSIdLoaiMon();
        ArrayAdapter<Integer> integerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, integers);
        spIdLM.setAdapter(integerArrayAdapter);
    }

    public void setupSpinnerIdMA() {
        List<Integer> integerList = new ArrayList<>();
        integerList = databaseHelper.layDSIdMonAn();
        ArrayAdapter<Integer> integerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, integerList);
        spIdMA.setAdapter(integerArrayAdapter);
    }

    public void setupListView() {
        loaiMonAns = databaseHelper.layLoaiMonAn();
        ArrayAdapter<LoaiMonAn> loaiMonAnArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, loaiMonAns);
        lvLMA.setAdapter(loaiMonAnArrayAdapter);
    }

    public void themLoaiMA(LoaiMonAn loaiMonAn){
        databaseHelper.themLoaiMonAn(loaiMonAn);
        setupListView();
    }
}
