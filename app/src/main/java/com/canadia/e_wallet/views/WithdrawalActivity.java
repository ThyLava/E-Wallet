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
import com.canadia.e_wallet.helper.ShareInstance;

public class WithdrawalActivity extends AppCompatActivity {
    TextView total_payment,total_wallet;
    Button btn_main_screen;

    @SuppressLint("SetTextI18n")
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
        total_wallet = findViewById(R.id.total_wallet);
        total_wallet.setText("$ "+ShareInstance.TotalBalance.toString());

        Intent intent = getIntent();
        String total = intent.getStringExtra("total");
        total_payment.setText("$ "+total);

        btn_main_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next_intent = new Intent(getBaseContext(), HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(next_intent);
            }
        });

    }

}