package com.christianhur.dynamicfragments.models;

public class User {
    private String name;
    private String title;
    private String email;
    public static String[] USER_NAMES = {"Abel Smith","Bailey Lee","Chris Jones"};
    public static User[] users = {
         new User(USER_NAMES[0],"CEO","smith@myco.com"),
         new User(USER_NAMES[1],"SR. SDE","blee@myco.com"),
         new User(USER_NAMES[2],"JR. Developer","cjones@myco.com"),
    };

    public User(String name, String title, String email){
        this.setName(name);
        this.setEmail(email);
        this.setTitle(title);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
