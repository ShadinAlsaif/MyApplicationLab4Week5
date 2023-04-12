package com.example.myapplicationlab4week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_add, btn_view;
    EditText et_name, et_age;
    ListView Iv_StudentList;
    ArrayAdapter studentArrayAdapter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_view = findViewById(R.id.btn_view);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        Iv_StudentList = findViewById(R.id.Iv_StudentList);
        dataBaseHelper = new DataBaseHelper(MainActivity.this);
        showStudensOnListView(dataBaseHelper);

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataBaseHelper = new DataBaseHelper(MainActivity.this);
                //Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
                showStudensOnListView(dataBaseHelper);


            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "add button", Toast.LENGTH_SHORT).show();
                StudentMod studentMod;
                try {
                    studentMod = new StudentMod(et_name.getText().toString(), -1, Integer.parseInt(et_age.getText().toString()));
                    Toast.makeText(MainActivity.this, studentMod.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                    studentMod = new StudentMod("ERROR", -1, 0);

                }


                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(studentMod);

                Toast.makeText(MainActivity.this, "success" + success, Toast.LENGTH_SHORT).show();
                showStudensOnListView(dataBaseHelper);
            }
        });


    }
          private void showStudensOnListView(DataBaseHelper dataBaseHelper) {
          studentArrayAdapter = new ArrayAdapter<StudentMod>(MainActivity.this,android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
          Iv_StudentList.setAdapter(studentArrayAdapter);
        }
    }