package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.canadia.e_wallet.R;
import com.google.android.material.chip.Chip;

public class TransactionDetailActivity extends AppCompatActivity {
    ImageView payment_img;
    TextView status,title,date,date_payment,mainTitle,mytitle;
    Chip detail_chip;
    Button btn_transfer_next;
    ImageView action_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_transaction_detail);
        getToolbar();

        payment_img = findViewById(R.id.payment_img);
        status = findViewById(R.id.label_chip);
        title = findViewById(R.id.mainTitle);
        date = findViewById(R.id.date_pay);
        date_payment = findViewById(R.id.payment_date);
        mainTitle = findViewById(R.id.transfer);
//        detail_chip = findViewById(R.id.label_chip);
        Intent intent = getIntent();
        String mtitle = intent.getStringExtra("title");
        String mstatus = intent.getStringExtra("status");
        String mdate = intent.getStringExtra("date");

        title.setText(mtitle);
        status.setText(mstatus);
        date.setText(mdate);
        date_payment.setText(mdate);
        mainTitle.setText(mtitle);
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            int image_id = bundle.getInt("image");
//            int color_id = bundle.getInt("color");
            payment_img.setImageResource(image_id);
//            detail_chip.setChipBackgroundColorResource(color_id);
        }


    }
    private void getToolbar() {
        mytitle = findViewById(R.id.app_title_bar);
        action_back = findViewById(R.id.back);
        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mytitle.setText("Transaction Details");
//       ActionBar.registerSupportToolbar(this, action_back);


    }
}