package com.christianhur.myfavoriteactivities.models;

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    public static User[] users = {
            new User("asmith","Adam","Smith","smitha@myco.com"),
            new User("bjones","Betty","Jones","jonesb@jones.com"),
            new User("hpotter","Harry","Potter","potterh@potterinc.com"),
    };

    public User(String userName, String firstName, String lastName, String email){
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
