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

import com.canadia.e_wallet.R;

public class PersonalInfoActivity extends AppCompatActivity implements View.OnClickListener{

    EditText firstName,lastName;
    Button btn_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_personal_info);
        bindViewID();
        btn_username.setOnClickListener(this);
        firstName.addTextChangedListener(userNameTextWatcher);
        lastName.addTextChangedListener(userNameTextWatcher);

    }
    private TextWatcher userNameTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String first_name = firstName.getText().toString().trim();
            String last_name = lastName.getText().toString().trim();
            btn_username.setEnabled(!first_name.isEmpty() && !last_name.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_enter_username:
                String m_first_name = firstName.getText().toString();
                Intent next_intent = new Intent(getBaseContext(), WelcomeActivity.class);
                next_intent.putExtra("first_name",m_first_name);
                startActivity(next_intent);
                break;
        }
    }
    public void bindViewID(){

        //find id
        firstName = findViewById(R.id.tv_first_name);
        lastName = findViewById(R.id.tv_last_name);
        btn_username = findViewById(R.id.btn_enter_username);
    }
}