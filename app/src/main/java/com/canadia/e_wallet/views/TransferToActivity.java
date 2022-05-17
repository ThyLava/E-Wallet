package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.ShareInstance;

public class TransferToActivity extends AppCompatActivity implements View.OnClickListener{
    EditText card_number,amount,msg;
    de.hdodenhof.circleimageview.CircleImageView logo;
    Button btn_transfer_next;
    ImageView action_back;
    TextView title,bank_name,error_text;
    Double balance_after_transfer;
    String total_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_transfer_to);
        getToolbar();

        bindViewID();

        card_number.addTextChangedListener(transferToTextWatcher);
        amount.addTextChangedListener(balanceCheck);
        msg.addTextChangedListener(transferToTextWatcher);
        Intent i = getIntent();
        logo.setImageResource(i.getIntExtra("img",0));
        bank_name.setText(i.getStringExtra("name"));
        btn_transfer_next.setOnClickListener(this);
        error_text.setVisibility(View.VISIBLE);
        error_text.setText("");
    }
    // set enable button
    private final TextWatcher transferToTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void afterTextChanged(Editable editable) {
            btn_transfer_next.setEnabled(isEnableNext());
        }
    };
    private final TextWatcher balanceCheck = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            btn_transfer_next.setEnabled(isEnableNext());
            if(total_amount.isEmpty()){
                error_text.setText("Required");
            }else if(ShareInstance.TotalBalance<Double.parseDouble(total_amount)){
                error_text.setText("Not enough");
            }else{
                error_text.setText("");
            }
        }
    };

    private Boolean isEnableNext(){
        total_amount = amount.getText().toString().trim();
        String card = card_number.getText().toString().trim();
        return !(card.isEmpty() || total_amount.isEmpty() || ShareInstance.TotalBalance<Double.parseDouble(total_amount));
    };

    private void bindViewID(){
        card_number = findViewById(R.id.card_number);
        amount = findViewById(R.id.amount);
        msg = findViewById(R.id.msg);
        logo = findViewById(R.id.logo_bank);
        bank_name = findViewById(R.id.name_bank);
        btn_transfer_next = findViewById(R.id.btn_transfer_next);
        error_text = findViewById(R.id.error_text);
    }
    @SuppressLint("SetTextI18n")
    private void getToolbar() {
        title = findViewById(R.id.app_title_bar);
        action_back = findViewById(R.id.back);
        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        title.setText("Transfer To ...");
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_transfer_next:
                    balance_after_transfer = ShareInstance.TotalBalance - Double.parseDouble(total_amount);
                    ShareInstance.TotalBalance = balance_after_transfer;
                Intent next_intent = new Intent(getBaseContext(),WithdrawalActivity.class);
                next_intent.putExtra("total",total_amount);
                startActivity(next_intent);
                break;
        }
    }
}