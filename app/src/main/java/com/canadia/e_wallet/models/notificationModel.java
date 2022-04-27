package com.canadia.e_wallet.models;

public class notificationModel {
    private String title,date,chip;
    private int payment_image;
    private int status_color;

    public notificationModel(String title,String date, String chip,int payment_image,int status_color){
        this.title = title;
        this.date = date;
        this.chip = chip;
        this.payment_image = payment_image;
        this.status_color = status_color;

    }

    public int getStatus_color() {
        return status_color;
    }

    public void setStatus_color(int status_color) {
        this.status_color = status_color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getPayment_image() {
        return payment_image;
    }

    public void setPayment_image(int payment_image) {
        this.payment_image = payment_image;
    }
}
