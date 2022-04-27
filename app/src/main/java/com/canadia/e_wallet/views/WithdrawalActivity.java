package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.canadia.e_wallet.MainActivity;
import com.canadia.e_wallet.R;

public class WithdrawalActivity extends AppCompatActivity {
    TextView total_payment;
    Button btn_main_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_withdrawal);

        //find id
        total_payment = findViewById(R.id.total);
        btn_main_screen = findViewById(R.id.btn_main_screen);

        Intent intent = getIntent();
        String total = intent.getStringExtra("total");
        total_payment.setText("$ "+total);

        btn_main_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next_intent = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(next_intent);
            }
        });

    }

}