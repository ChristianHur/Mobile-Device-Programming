package com.christianhur.mysqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class ResultActivity extends AppCompatActivity {
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;
    private Cursor cursor;
    private RadioGroup radioGroup;
    private int radioId;

    @Override
    protected void onRestart() {
        super.onRestart();
        Cursor newCursor = cursor = db.query("user",
                null,
                null,
                null,
                null,
                null,
                null);
        ListView listView = findViewById(R.id.list_users);
        CursorAdapter adapter = (CursorAdapter)listView.getAdapter();
        adapter.changeCursor(newCursor);
        cursor = newCursor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Create an instance of the MyDbHelper
        myDbHelper = new MyDbHelper(this);

        // Create the database instance
        try {
            db = myDbHelper.getReadableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Create cursor
        cursor = db.query("user",
                null,
                null,
                null,
                null,
                null,
                null);

        ListView listView = findViewById(R.id.list_users);
        CursorAdapter listAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"name"},
                new int[]{android.R.id.text1},
                0);

        listView.setAdapter( listAdapter );

        //Add button
        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, AddActivity.class));
            }
        });

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioId = checkedId;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (radioId){
                    case R.id.rad_update:
                        //update
                        Intent intent = new Intent(ResultActivity.this, UpdateActivity.class);
                        intent.putExtra("USER_ID",(int)id);
                        startActivity(intent);

                        Toast.makeText(ResultActivity.this,"Record Updated",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rad_delete:
                        if( myDbHelper.deleteOne(db,(int)id) ) {
                            onRestart();
                            Toast.makeText(ResultActivity.this, "Record Deleted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ResultActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        Toast.makeText(ResultActivity.this,"Please Select an Option",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }















}