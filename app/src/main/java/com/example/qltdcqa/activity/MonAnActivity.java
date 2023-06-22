package com.example.qltdcqa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.qltdcqa.R;
import com.example.qltdcqa.database.DatabaseHelper;
import com.example.qltdcqa.model.MonAn;

import java.util.List;

public class MonAnActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    EditText edt2, edt3, edt4;

    Button btMonAn;

    ListView lvMonAn;

    List<MonAn> monAns;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_an);

        databaseHelper = new DatabaseHelper(this);

        edt2 = findViewById(R.id.edtTenMon);
        edt3 = findViewById(R.id.edtGia);
        edt4 = findViewById(R.id.edtThoiGian);
        btMonAn = findViewById(R.id.btnThemMon);
        lvMonAn = findViewById(R.id.lvMon);

        btMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonAn monAn = new MonAn();
                monAn.setTenMon(edt2.getText().toString());
                monAn.setGiaDat(Integer.parseInt(edt3.getText().toString()));
                monAn.setThoiGianLamMon(Integer.parseInt(edt4.getText().toString()));
                themMonAn(monAn);
                edt2.setText("");
                edt3.setText("");
                edt4.setText("");
            }
        });
    }

    private void setupListView() {
        monAns = databaseHelper.layDSMonAn();
        ArrayAdapter<MonAn> monAnArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, monAns);
        lvMonAn.setAdapter(monAnArrayAdapter);
    }

    private void themMonAn(MonAn monAn) {
        databaseHelper.themMonAn(monAn);
        setupListView();
    }
}
