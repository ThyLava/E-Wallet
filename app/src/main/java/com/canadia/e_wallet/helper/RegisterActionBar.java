package com.canadia.e_wallet.helper;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.canadia.e_wallet.R;

public class RegisterActionBar {
    public static void registerSupportToolbar(AppCompatActivity applicationContext, ImageView action_back){
        if (applicationContext.getSupportActionBar()!=null){
            applicationContext.getSupportActionBar().setTitle("");
            applicationContext.getSupportActionBar().setHomeAsUpIndicator(R.drawable.action);
            applicationContext.getSupportActionBar().setHomeAsUpIndicator(R.drawable.info);
            applicationContext.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
