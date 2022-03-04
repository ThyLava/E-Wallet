package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.ActionBar;
import com.canadia.e_wallet.helper.RegisterActionBar;

public class InstructionActivity extends AppCompatActivity {
    ImageView action_back;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_instruction);
        getToolbar();
    }
    private void getToolbar() {
        title = findViewById(R.id.app_title_bar);
        action_back = findViewById(R.id. back);
        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        title.setText("");
//       ActionBar.registerSupportToolbar(this, action_back);


    }
}