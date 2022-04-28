package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.MainActivity;
import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.OnButtonClick;
import com.canadia.e_wallet.helper.Tool;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    EditText password;
    Spanned signOutText;
    TextView tv_sign_out,tv_first_name,tv_forgot_pwd;
    Button login,login_finger,login_face;
    String first_name;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_welcome);
        findViewID();

        Intent intent = getIntent();
        first_name = intent.getStringExtra("first_name");

        tv_first_name.setText(first_name);

        password.addTextChangedListener(passwordTextWatcher);
        signOutText = Html.fromHtml("<a href=''>Sign out</a>");
        tv_sign_out.setText(signOutText);
        tv_forgot_pwd.setOnClickListener(this);
        tv_sign_out.setOnClickListener(this);
        login_finger.setOnClickListener(this);
        login_face.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    private final TextWatcher passwordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String password_enter = password.getText().toString().trim();
            login.setEnabled(!password_enter.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void findViewID(){
        tv_sign_out = findViewById(R.id.tv_sign_out);
        password = findViewById(R.id.welcome_password);
        login = findViewById(R.id.btn_login);
        tv_first_name = findViewById(R.id.first_name_show);
        tv_forgot_pwd = findViewById(R.id.tv_forgot_pwd);
        login_finger = findViewById(R.id.btn_login_finger);
        login_face = findViewById(R.id.btn_login_face_id);
        logo = findViewById(R.id.your_choice);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_forgot_pwd:
                startActivity(new Intent(getBaseContext(),ForgotPasswordActivity.class));
                break;
            case R.id.btn_login:
                startActivity(new Intent(getBaseContext(),HomeActivity.class));
                break;
            case R.id.tv_sign_out:
                Tool.threeParameterDialog(WelcomeActivity.this, "Are you sure you want to sign out ?", new OnButtonClick() {
                    @Override
                    public void buttonClick() {
                       startActivity(new Intent(getBaseContext(),MainActivity.class));
                    }
                });
                break;
            case R.id.btn_login_face_id:
                Tool.loginChoice(WelcomeActivity.this, logo, "Face ID for APAY", "Use your face ID to login", new OnButtonClick() {
                    @Override
                    public void buttonClick() {

                    }
                });
                break;
            case R.id.btn_login_finger:
                Tool.loginChoice(WelcomeActivity.this, logo, "Finger print for APAY", "Use your finger print to login", new OnButtonClick() {
                    @Override
                    public void buttonClick() {

                    }
                });
                break;

        }
    }
}