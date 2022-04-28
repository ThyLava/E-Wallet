package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import android.widget.Toast;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.RegisterActionBar;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{
//    Toolbar mToolbar;
    ImageView action_info,action_back;
    TextView title;
    EditText id_number,your_email;
    Button btn_sent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_forgot_password);

//        call back function
        getToolbar();
        bindViewID();

//        textWatcher function call back
        id_number.addTextChangedListener(InputTextWatcher);
        your_email.addTextChangedListener(InputTextWatcher);

        action_info.setOnClickListener(this);
        btn_sent.setOnClickListener(this);
        action_back.setOnClickListener(this);

    }
    // text watcher
    private final TextWatcher InputTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String your_id_number = id_number.getText().toString().trim();
            String email = your_email.getText().toString().trim();
            btn_sent.setEnabled(!your_id_number.isEmpty() && !email.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    // action bar
    private void getToolbar() {
        bindViewID();
        title.setText("Forgot Password");
        RegisterActionBar.registerSupportToolbar(this, action_back);
    }
    // bind view by id
    public void bindViewID(){
        id_number = findViewById(R.id.id_number);
        your_email = findViewById(R.id.email);
        btn_sent = findViewById(R.id.btn_sent);
        title = findViewById(R.id.appBarTitle);
        action_info = findViewById(R.id.action_info);
        action_back = findViewById(R.id.action_back);
    }
    // click action
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.action_info:
                startActivity(new Intent(getApplicationContext(),InstructionActivity.class));
                break;
            case  R.id.btn_sent:
                Toast.makeText(getApplicationContext(),"Already Sent ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_back:
                onBackPressed();
                break;
        }

    }
}