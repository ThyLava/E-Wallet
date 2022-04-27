package com.canadia.e_wallet.models;

public class PayModel {
    private String pay_name;
    private int pay_image;

    public PayModel(String pay_name, int pay_image) {
        this.pay_name = pay_name;
        this.pay_image = pay_image;
    }

    public String getPay_name() {
        return pay_name;
    }

    public void setPay_name(String pay_name) {
        this.pay_name = pay_name;
    }

    public int getPay_image() {
        return pay_image;
    }

    public void setPay_image(int pay_image) {
        this.pay_image = pay_image;
    }
}
