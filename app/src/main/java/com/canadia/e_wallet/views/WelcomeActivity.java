package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.OnButtonClick;
import com.canadia.e_wallet.helper.Tool;

public class WelcomeActivity extends AppCompatActivity {
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

        // find id

        tv_sign_out = findViewById(R.id.tv_sign_out);
        password = findViewById(R.id.welcome_password);
        login = findViewById(R.id.btn_login);
        tv_first_name = findViewById(R.id.first_name_show);
        tv_forgot_pwd = findViewById(R.id.tv_forgot_pwd);
        login_finger = findViewById(R.id.btn_login_finger);
        login_face = findViewById(R.id.btn_login_face_id);
        logo = findViewById(R.id.your_choice);

        tv_forgot_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_intent = new Intent(getBaseContext(), ForgotPasswordActivity.class);
                startActivity(next_intent);
            }
        });
        Intent intent = getIntent();
        first_name = intent.getStringExtra("first_name");

        tv_first_name.setText(first_name);

        password.addTextChangedListener(passwordTextWatcher);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"WELCOME ",Toast.LENGTH_SHORT).show();
            }
        });

        signOutText = Html.fromHtml("<a href=''>Sign out</a>");
        tv_sign_out.setText(signOutText);

        tv_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tool.comfirmSignout(WelcomeActivity.this, "Are you sure you want to sign out ?", new OnButtonClick() {
                    @Override
                    public void buttonClick() {
                        Toast.makeText(getApplicationContext(),"already sign out !!",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // dialog login with finger

        login_finger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tool.loginFingerPrint(WelcomeActivity.this, logo, "Finger print for APAY", "Use your finger print to login", new OnButtonClick() {
                    @Override
                    public void buttonClick() {

                    }
                });
            }
        });

        // dialog login with face ID

        login_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tool.loginFaceID(WelcomeActivity.this, logo, "Face ID for APAY", "Use your face ID to login", new OnButtonClick() {
                    @Override
                    public void buttonClick() {

                    }
                });
            }
        });
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
}