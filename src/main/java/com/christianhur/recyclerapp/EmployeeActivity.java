package com.christianhur.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.christianhur.recyclerapp.models.Employee;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        int ee_id = getIntent().getIntExtra("EE_id", 0);

        //set references
        ImageView imageView = (ImageView) findViewById(R.id.img_employee_avatar);
        TextView txt_name = (TextView) findViewById(R.id.txt_employee_name);
        TextView txt_title = (TextView) findViewById(R.id.txt_employee_title);
        TextView txt_description = (TextView) findViewById(R.id.txt_employee_description);

        // setting data
//        imageView.setImageResource(Employee.imgResources[ee_id]);
        imageView.setImageResource(Employee.employeeList[ee_id].getImgResource());
        txt_name.setText(Employee.employeeList[ee_id].getName());
        txt_title.setText(Employee.employeeList[ee_id].getTitle());
        txt_description.setText(Employee.employeeList[ee_id].getDescription());
    }
}