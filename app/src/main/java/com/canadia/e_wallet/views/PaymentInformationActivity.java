package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.ShareInstance;

public class PaymentInformationActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    Spinner receive_bank;
    de.hdodenhof.circleimageview.CircleImageView logo;
    ImageView action_back;
    TextView title, bank_name,bank_desc,total;
    EditText amount;
    String total_amount;
    Button confirm;
    Double balance_after_pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_payment_information);
        getToolbar();
        bindViewByID();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balance_after_pay = ShareInstance.TotalBalance - Double.parseDouble(total_amount);
                ShareInstance.TotalBalance = balance_after_pay;
                Intent next_intent = new Intent(getBaseContext(),WithdrawalActivity.class);
                next_intent.putExtra("total",total_amount);
                startActivity(next_intent);
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.banks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        receive_bank.setAdapter(adapter);
        receive_bank.setOnItemSelectedListener(this);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");

        bank_name.setText(name);
        bank_desc.setText(desc);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            int image_bank = bundle.getInt("logo");
            logo.setImageResource(image_bank);
        }

    }

    // bind view by id
    private void bindViewByID(){
        logo = findViewById(R.id.logo);
        bank_name = findViewById(R.id.title_bank);
        bank_desc = findViewById(R.id.sub_bank);
        amount = findViewById(R.id.amount);
        total = findViewById(R.id.total);
        amount.addTextChangedListener(totalPayment);
        receive_bank = findViewById(R.id.receive_bank);
        receive_bank = findViewById(R.id.receive_bank);
        confirm = findViewById(R.id.confirm);
    }
    // action bar
    private void getToolbar() {
        title = findViewById(R.id.app_title_bar);
        action_back = findViewById(R.id.back);
        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        title.setText("Payment Information ");


    }
    private TextWatcher totalPayment = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            double amount_payment;
            if(amount.getText().toString().isEmpty()){
                amount_payment=0.0;
            }else{
                amount_payment=Double.parseDouble(amount.getText().toString());
            }

            double total_payment = amount_payment + 1.0;
             total_amount= String.valueOf(total_payment);
            total.setText("$ "+ total_amount);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}