package com.example.qltdcqa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qltdcqa.R;
import com.example.qltdcqa.database.DatabaseHelper;
import com.example.qltdcqa.model.MonAn;

import java.util.ArrayList;
import java.util.List;

public class LietKeActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    ListView lvLietKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liet_ke);

        databaseHelper = new DatabaseHelper(this);

        lvLietKe = findViewById(R.id.lvLK);

        List<MonAn> monAns = new ArrayList<>();
        monAns = databaseHelper.layDSLietKe();
        ArrayAdapter<MonAn> monAnArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, monAns);
        lvLietKe.setAdapter(monAnArrayAdapter);

    }
}
