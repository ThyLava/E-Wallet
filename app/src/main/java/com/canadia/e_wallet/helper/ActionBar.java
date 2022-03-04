package com.canadia.e_wallet.helper;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.canadia.e_wallet.R;

public class ActionBar {
    public static void registerSupportToolbar(AppCompatActivity applicationContext, ImageView action_back){
        if (applicationContext.getSupportActionBar()!=null){
            applicationContext.getSupportActionBar().setTitle("");
            applicationContext.getSupportActionBar().setHomeAsUpIndicator(R.drawable.action);
            applicationContext.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
