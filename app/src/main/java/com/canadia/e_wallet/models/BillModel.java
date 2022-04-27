package com.canadia.e_wallet.models;

public class BillModel {
    private String bill_name;
    private int bill_image;

    public BillModel(String bill_name, int bill_image) {
        this.bill_name = bill_name;
        this.bill_image = bill_image;
    }

    public String getBill_name() {
        return bill_name;
    }

    public void setBill_name(String bill_name) {
        this.bill_name = bill_name;
    }

    public int getBill_image() {
        return bill_image;
    }

    public void setBill_image(int bill_image) {
        this.bill_image = bill_image;
    }
}