package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.canadia.e_wallet.MainActivity;
import com.canadia.e_wallet.R;

public class PasswordActivity extends AppCompatActivity {

    EditText enter_password,re_enter_password;
    Button btn_enter_password;
    TextView show_incorrect_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_password);

        //find id
        enter_password = findViewById(R.id.enter_password);
        re_enter_password = findViewById(R.id.re_enter_password);
        btn_enter_password = findViewById(R.id.btn_enter_password);
        show_incorrect_password = findViewById(R.id.tv_incorrect_password);

        enter_password.addTextChangedListener(passwordTextWatcher);
        re_enter_password.addTextChangedListener(passwordTextWatcher);
        btn_enter_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String m_password = enter_password.getText().toString();
                String m_re_password = re_enter_password.getText().toString();
                if(m_password.length()==6 && m_re_password.length()==6){
                    if(m_password.equals(m_re_password)){
                        Intent next_intent = new Intent(getBaseContext(), PersonalInfoActivity.class);
                        startActivity(next_intent);
                        show_incorrect_password.setVisibility(View.INVISIBLE);
                    }else {
                        show_incorrect_password.setVisibility(View.VISIBLE);
                    }
                }

            }
        });

    }
    private final TextWatcher passwordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String password = enter_password.getText().toString().trim();
            String re_password = re_enter_password.getText().toString().trim();
            btn_enter_password.setEnabled(!password.isEmpty() && !re_password.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}