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

public class TransferToActivity extends AppCompatActivity implements View.OnClickListener{
    EditText card_number,amount,msg;
    de.hdodenhof.circleimageview.CircleImageView logo;
    Button btn_transfer_next;
    ImageView action_back;
    TextView title,bank_name;
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
        amount.addTextChangedListener(transferToTextWatcher);
        msg.addTextChangedListener(transferToTextWatcher);
        Intent i = getIntent();
        logo.setImageResource(i.getIntExtra("img",0));
        bank_name.setText(i.getStringExtra("name"));
        btn_transfer_next.setOnClickListener(this);
    }
    // set enable button
    private final TextWatcher transferToTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String card = card_number.getText().toString().trim();
            String total_amount = amount.getText().toString().trim();
            String message = msg.getText().toString().trim();
            if(!card.isEmpty() && !total_amount.isEmpty() && !message.isEmpty()){
                btn_transfer_next.setEnabled(true);
            }
        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void bindViewID(){
        card_number = findViewById(R.id.card_number);
        amount = findViewById(R.id.amount);
        msg = findViewById(R.id.msg);
        logo = findViewById(R.id.logo_bank);
        bank_name = findViewById(R.id.name_bank);
        btn_transfer_next = findViewById(R.id.btn_transfer_next);
    }
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
//       ActionBar.registerSupportToolbar(this, action_back);


    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_transfer_next:
                startActivity(new Intent(getBaseContext(),WithdrawalActivity.class));
                break;
        }
    }
}