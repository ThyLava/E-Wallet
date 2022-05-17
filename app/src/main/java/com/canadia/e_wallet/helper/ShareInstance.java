package com.canadia.e_wallet.helper;

public class ShareInstance {
    private static ShareInstance instance;
    public static ShareInstance getInstance(){
        if(instance == null)
            instance = new ShareInstance();
        return instance;

    }
    public static Double TotalBalance = 100.95;
}
