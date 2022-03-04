package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.OnButtonClick;
import com.canadia.e_wallet.helper.Tool;

public class NewPhoneNumberActivity extends AppCompatActivity {

    Button btn_new_number;
    String new_confirm;    EditText new_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_new_phone_number);

        Intent intent = getIntent();
        new_confirm = intent.getStringExtra("new_phone_number");
        //find id
        new_number = findViewById(R.id.input_new_phone_number);
        btn_new_number = findViewById(R.id.btn_next_new_phone);

        new_number.addTextChangedListener(newPhoneTextWatcher);

        btn_new_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Tool.confirmNexPhoneDialog(
                        NewPhoneNumberActivity.this,
                        "Login with phone number :", new_number.getText().toString(),
                        "We will send a verification code to the "+"\n"+
                                "phone number you entered."+"\n"+"do you want to continue",
                        new OnButtonClick() {
                            @Override
                            public void buttonClick() {

                                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                                String new_phone_number = new_number.getText().toString();
                                Intent next_intent = new Intent(getBaseContext(), VerifyActivity.class);
                                next_intent.putExtra("new_phone_number",new_phone_number);
                                startActivity(next_intent);
                            }
                        });
            }
        });

    }

    private TextWatcher newPhoneTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String new_phone_number = new_number.getText().toString().trim();
            btn_new_number.setEnabled(!new_phone_number.isEmpty() && new_phone_number.length()<10);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}