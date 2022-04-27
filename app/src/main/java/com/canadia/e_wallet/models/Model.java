package com.canadia.e_wallet.models;

import android.widget.ImageView;

public class Model {
    private int bank_image;
    private String bank_name,bank_desc;

    public Model(int bank_image, String bank_name, String bank_desc){
        this.bank_image = bank_image;
        this.bank_name = bank_name;
        this.bank_desc = bank_desc;
    }

    public int getBank_image() {
        return bank_image;
    }

    public void setBank_image(int bank_image) {
        this.bank_image = bank_image;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_desc() {
        return bank_desc;
    }

    public void setBank_desc(String bank_desc) {
        this.bank_desc = bank_desc;
    }
}
