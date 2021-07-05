package com.christianhur.myfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity( new Intent(MainActivity.this, WorkoutActivity.class) );
//            }
//        });
    }

    @Override
    public void itemClicked(int id) {
        Intent intent = new Intent(this, WorkoutActivity.class);
        intent.putExtra("WORK_ID",id);
        startActivity(intent);
    }
}