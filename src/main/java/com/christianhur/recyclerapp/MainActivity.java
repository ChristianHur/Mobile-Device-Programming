package com.christianhur.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view,container,false);

        // Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        // Create the adapter and pass it to recycler
        EmployeeAdapter employeeAdapter = new EmployeeAdapter();
        recyclerView.setAdapter(employeeAdapter);

        //Inner Class -- Callback (Callback function)
        employeeAdapter.setListener(new EmployeeAdapter.Listener() {
            @Override
            public void onClickedEmployee(int position) {
                Intent intent = new Intent(MainActivity.this,EmployeeActivity.class);
                intent.putExtra("EE_id",position);
                startActivity(intent);
            }
        });
    }
}