package com.example.android_project.entities;

public enum FoodTypes {

    MainDish("MainMeal"),
    Salad("Salad"),
    HotDrinks("HDrinks"),
    ColdDrinks("CDrinks");

    private final String foodtype;

    FoodTypes(String envUrl) {
        this.foodtype = envUrl;
    }

    public String getType() {
        return foodtype;
    }
}
