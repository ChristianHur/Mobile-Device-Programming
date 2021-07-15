package com.christianhur.listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Drink id (index)
        int drinkId = (int)getIntent().getExtras().get("DRINK_ID");
        int drinkId2 = getIntent().getIntExtra("DRINK_ID",0);
        Drink[] drinks = Drink.getDrinks();
        //Set references
        ImageView imageView = (ImageView) findViewById(R.id.img_drink);
        TextView txt_drink_name = (TextView) findViewById(R.id.txt_drink_name);
        TextView txt_drink_desc = (TextView) findViewById(R.id.txt_drink_description);

        txt_drink_name.setText( drinks[drinkId].getName() );
        txt_drink_desc.setText( drinks[drinkId].getDescription());
        imageView.setImageResource( drinks[drinkId].getImgResourceId());
    }
}