package com.christianhur.listviewactivity;

public class Drink {
    private String name;
    private String description;
    private int imgResourceId;

    private static Drink[] drinks = createDrinks();

    public Drink(String name, String description, int imgResourceId){
        this.setDescription(description);
        this.setName(name);
        this.setImgResourceId(imgResourceId);
    }

    @Override
    public String toString() {
        return name;
    }

    private static Drink[] createDrinks() {
        Drink[] drinks = {
                new Drink("Latte","Hot latte",R.drawable.latte),
                new Drink("Cappuccino", "Bitter drink", R.drawable.cappuccino),
                new Drink("Filter","Freshly brewed coffee",R.drawable.filter)
        };
        return drinks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public static Drink[] getDrinks() {
        return drinks;
    }

    public static void setDrinks(Drink[] drinks) {
        Drink.drinks = drinks;
    }
}
