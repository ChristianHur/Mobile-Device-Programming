package com.christianhur.mysqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private int id;
    private EditText txt_name;
    private EditText txt_title;
    MyDbHelper myDbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id = getIntent().getIntExtra("USER_ID",0);

        txt_name = findViewById(R.id.txt_name);
        txt_title = findViewById(R.id.txt_title);
        myDbHelper = new MyDbHelper(UpdateActivity.this);
        db = myDbHelper.getWritableDatabase();

        displayForm();

        Button btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myDbHelper.updateData(db,id,txt_name.getText().toString(),txt_title.getText().toString())){
                    Toast.makeText(UpdateActivity.this, "Record Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(UpdateActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void displayForm(){
        Cursor cursor = db.query("user",new String[]{"name","title"},"_id = ?", new String[]{Integer.toString(id)},null,null,null);

        if(cursor.moveToFirst()){
            txt_name.setText( cursor.getString(0) );
            txt_title.setText(cursor.getString( cursor.getColumnIndex("title") ));
        }
    }
}