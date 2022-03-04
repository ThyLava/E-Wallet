package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

public class ForgotPasswordActivity extends AppCompatActivity {
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

//        call back function get toolbar
        getToolbar();

        //find id
        id_number = findViewById(R.id.id_number);
        your_email = findViewById(R.id.email);
        btn_sent = findViewById(R.id.btn_sent);

//        textWatcher function call back
        id_number.addTextChangedListener(InputTextWatcher);
        your_email.addTextChangedListener(InputTextWatcher);

        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Already Sent ",Toast.LENGTH_SHORT).show();
            }
        });
    }
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
        title = findViewById(R.id.appBarTitle);
        action_info = findViewById(R.id.action_info);
        action_back = findViewById(R.id.action_back);
        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        action_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_intent = new Intent(getBaseContext(), InstructionActivity.class);
                startActivity(next_intent);
            }
        });
        title.setText("Forgot Password");
        RegisterActionBar.registerSupportToolbar(this, action_back);


    }
}