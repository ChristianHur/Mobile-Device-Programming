package com.christianhur.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinksCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_category);
        setTitle("Drinks Category");

        ListView listView = (ListView) findViewById(R.id.lst_drinks);

        //Populate the list view
        listView.setAdapter(new ArrayAdapter<Drink>(
                DrinksCategoryActivity.this,
                android.R.layout.simple_list_item_1,
                Drink.getDrinks()
                ));

        //Add event listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrinksCategoryActivity.this,DrinkActivity.class);
                intent.putExtra("DRINK_ID",position);
                startActivity(intent);
            }
        });

    }
}