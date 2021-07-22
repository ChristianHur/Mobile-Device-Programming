package com.christianhur.mysqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    private static String db_name = "my_db";
    private static int db_version = 1;
    private static String table_name = "user";
    private Context context;

    public MyDbHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db,0,db_version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateDatabase(db,oldVersion, newVersion);
    }

    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion){

        if(oldVersion < 1){
            //Create table
            String query = "CREATE TABLE " + table_name + "( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT," +
                    "title TEXT);";
            db.execSQL(query);
            Toast.makeText(context,"DB Created!",Toast.LENGTH_SHORT).show();
        }
        if(oldVersion < 2){
            //Updated Db stuff
        }
    }

    public void insertData(SQLiteDatabase db, String name, String title){
        //Using raw SQL statements -- ANSI Standard
//        String query = "INSERT INTO " + table_name +
//                "(id,name,title) VALUES(null,'" + name + "','" + title +"');";
//        db.execSQL(query);

        //Built-in helper class/layer
        ContentValues inputValues = new ContentValues();
        inputValues.put("name",name);
        inputValues.put("title",title);
        db.insert(table_name,null,inputValues);

    }
    public void deleteOne(SQLiteDatabase db, int id){

    }
}
