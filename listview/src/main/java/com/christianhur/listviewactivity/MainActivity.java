package com.christianhur.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Page");

        ListView listView = (ListView) findViewById(R.id.lst_item);

        //Inner Anonymous Class
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemName = (String) listView.getItemAtPosition(position);
                switch(itemName){
                    case "Drinks":
                        loadActivity(DrinksCategoryActivity.class);
                        break;
                    case "Food":
                        loadActivity(FoodActivity.class);
                        break;
                    case "Cars":
                        loadActivity(CarsActivity.class);
                        break;
                }
            }
        });

    }

    public void loadActivity(Class activity){
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }

}