package com.canadia.e_wallet.models;

public class BankModel {
    private String bank_name;
    private int bank_image;

    public BankModel(String bank_name, int bank_image) {
        this.bank_name = bank_name;
        this.bank_image = bank_image;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public int getBank_image() {
        return bank_image;
    }

    public void setBank_image(int bank_image) {
        this.bank_image = bank_image;
    }
}
