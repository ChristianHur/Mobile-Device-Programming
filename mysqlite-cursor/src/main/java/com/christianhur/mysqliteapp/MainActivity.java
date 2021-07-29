package com.christianhur.mysqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of the MyDbHelper
        myDbHelper = new MyDbHelper(this);

        // Create the database instance
        db = myDbHelper.getReadableDatabase();

        //Insert data
        //myDbHelper.insertData(db,"Christian","CEO");

        EditText txt_name = (EditText) findViewById(R.id.txt_name);
        EditText txt_title = (EditText) findViewById(R.id.txt_title);
        Button btnSubmit = (Button) findViewById(R.id.btn_submit);
        Button btnShowAll = (Button) findViewById(R.id.btn_go);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDbHelper.insertData(db,txt_name.getText().toString(),txt_title.getText().toString());
            }
        });

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ResultActivity.class));
            }
        });

    }
}