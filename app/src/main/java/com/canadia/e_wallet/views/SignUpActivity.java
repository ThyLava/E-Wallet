package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.RegisterActionBar;

public class SignUpActivity extends AppCompatActivity {
    Button btn_next;
    EditText number;
    RadioButton agree;
    TextView term_condition;
    Spanned tv_term;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_sign_up);

//        find id
        agree = findViewById(R.id.agree_select);
        number = findViewById(R.id.input_phone_number);
        btn_next = findViewById(R.id.btn_next);
        term_condition = findViewById(R.id.tv_term_condition);
        tv_term =Html.fromHtml("I have read and agree to the " +"<a href='https://www.canadiabank.com.kh/'>term of use</a>"+"  of NPAY");
        term_condition.setMovementMethod(LinkMovementMethod.getInstance());
        term_condition.setText(tv_term);
        number.addTextChangedListener(nextTextWatcher);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = number.getText().toString();
                Intent next_intent = new Intent(getBaseContext(), VerifyActivity.class);
                next_intent.putExtra("phone_number",phone_number);
                startActivity(next_intent);
            }
        });

        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!agree.isSelected()){
                    agree.setChecked(true);
                    agree.setSelected(true);
                    if (!number.getText().toString().isEmpty() && !(number.getText().toString().length() <10)){
                        btn_next.setEnabled(true);
                    }else {
                        btn_next.setEnabled(false);
                    }
                }else {
                    agree.setChecked(false);
                    agree.setSelected(false);
                    btn_next.setEnabled(false);
                }
            }
        });
    }
    private TextWatcher nextTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String phone_number_input = number.getText().toString().trim();
            if (!phone_number_input.isEmpty()&& !(phone_number_input.length()<10)){
                if (agree.isChecked()){
                    btn_next.setEnabled(true);
                }else {
                    btn_next.setEnabled(false);
                }
            }else {
                btn_next.setEnabled(false);
            }
        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}