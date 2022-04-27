package com.canadia.e_wallet.models;

public class FoodModel {
    private String food_name;
    private String food_price;
    private String food_image;
    public FoodModel(String food_name,String food_price, String food_image){
        this.food_image = food_image;
        this.food_name = food_name;
        this.food_price = food_price;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_price() {
        return food_price;
    }

    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }
}
