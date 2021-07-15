package com.christianhur.recyclerapp.models;

import com.christianhur.recyclerapp.R;

public class Employee {
    private String name;
    private String title;
    private String description;
    private int imgResource;

//    public static int[] imgResources = {
//            R.drawable.employee1,R.drawable.employee2,R.drawable.employee3,
//            R.drawable.employee1,R.drawable.employee2,R.drawable.employee3,
//            R.drawable.employee1,R.drawable.employee2,R.drawable.employee3,
//            R.drawable.employee1,R.drawable.employee2,R.drawable.employee3
//    };

    public static Employee[] employeeList = {
            new Employee("Jack Frost","CEO","Hard working ceo.",R.drawable.employee1),
            new Employee("Mel Shrine","HR Manager","Retains all employees.",R.drawable.employee2),
            new Employee("Mary Jane","Developer","Intelligent coder.",R.drawable.employee3),
    };

    public Employee(String name, String title, String description, int imgResource){
        setDescription(description);
        setName(name);
        setTitle(title);
        setImgResource(imgResource);
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
