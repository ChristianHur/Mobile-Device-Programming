package com.christianhur.mysqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Create an instance of the MyDbHelper
        myDbHelper = new MyDbHelper(this);

        // Create the database instance
        db = myDbHelper.getReadableDatabase();

        TextView textView = (TextView) findViewById(R.id.textView);

        //Make a query
        //String query = "SELECT name FROM user ORDER BY name ASC";
        int id = 15;
        String query = "SELECT name FROM user WHERE id = ? ";
        Cursor cursor = db.rawQuery(query,new String[]{ Integer.toString(id) });
        String data = "";

        while(cursor.moveToNext()){
            data += cursor.getString(0) + "\n";
        }
        cursor.close();

        textView.setText(data);
    }
}
