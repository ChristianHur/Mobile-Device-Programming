package com.christianhur.myfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        int id = (int) getIntent().getIntExtra("WORK_ID",0);
        DetailFragment frag = (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.frag_detail);
        frag.setWorkId(id);


    }
}