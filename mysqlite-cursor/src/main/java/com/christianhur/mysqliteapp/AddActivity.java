package com.christianhur.mysqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txt_name = findViewById(R.id.txt_name);
                EditText txt_title = findViewById(R.id.txt_title);
                MyDbHelper myDbHelper = new MyDbHelper(AddActivity.this);
                SQLiteDatabase db = myDbHelper.getWritableDatabase();
                myDbHelper.insertData(db,txt_name.getText().toString(), txt_title.getText().toString() );

                Toast.makeText(AddActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}