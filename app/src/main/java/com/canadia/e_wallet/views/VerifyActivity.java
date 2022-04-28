package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.OnButtonClick;
import com.canadia.e_wallet.helper.Tool;
import com.chaos.view.PinView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class VerifyActivity extends AppCompatActivity implements View.OnClickListener{

    Button verify_otp;
    TextView canadiaLink,timeCountdown;
    Spanned Text;
    String phone_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_verify);
//        String phone_number = getIntent().toString().trim();
        Intent intent = getIntent();
        phone_number = intent.getStringExtra("phone_number");
        bindViewByID();
        setCountdown();
        pinViewVerify();
        canadiaLink.setOnClickListener(this);
        verify_otp.setOnClickListener(this);
        Text = Html.fromHtml("<a href=''>Change phone number</a>");
        canadiaLink.setMovementMethod(LinkMovementMethod.getInstance());
        canadiaLink.setText(Text);
    }

    public void setCountdown(){
        long duration = TimeUnit.MINUTES.toMillis(1);
        new CountDownTimer(duration, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                String sDuration = String.format(Locale.ENGLISH,"%02d:%02d",TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)));
                timeCountdown.setText("Send code again  "+"("+sDuration+")");
            }

            @Override
            public void onFinish() {
//                Toast.makeText(getApplicationContext(), "Sorry your time is limiting", Toast.LENGTH_SHORT).show();
                Tool.showDialog(VerifyActivity.this, "Did not you receive verification code ? ","We call "+phone_number + " to read your verification code", new OnButtonClick() {
                    @Override
                    public void buttonClick() {
                        setCountdown();
                    }
                });

            }

        }.start();
    }
    private void bindViewByID(){
        verify_otp = findViewById(R.id.btn_verify_otp);
        canadiaLink = findViewById(R.id.canadia_link);
        timeCountdown = findViewById(R.id.time_limit);


    }

    private void pinViewVerify(){
        final PinView pinView = findViewById(R.id.firstPinView);
        pinView.setTextColor(
                ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()));
        pinView.setTextColor(
                ResourcesCompat.getColorStateList(getResources(), R.color.black, getTheme()));
        pinView.setLineColor(
                ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()));
        pinView.setLineColor(
                ResourcesCompat.getColorStateList(getResources(), R.color.purple_200, getTheme()));
        pinView.setItemCount(6);
        pinView.setItemHeight(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        pinView.setItemWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        pinView.setItemRadius(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_radius));
        pinView.setItemSpacing(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing));
        pinView.setLineWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width));
        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.setCursorVisible(true);
        pinView.setCursorColor(ResourcesCompat.getColor(getResources(), R.color.blue, getTheme()));
        pinView.setCursorWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_cursor_width));
        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println(s.toString());
                System.out.println(pinView.getText().toString().equals("111111"));
                verify_otp.setEnabled(pinView.getText().toString().equals("111111"));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }});
        pinView.setItemBackgroundColor(Color.BLACK);
        pinView.setItemBackground(getResources().getDrawable(R.drawable.otp_style));
        pinView.setItemBackgroundResources(R.drawable.otp_style);
        pinView.setHideLineWhenFilled(false);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.canadia_link:
                Tool.threeParameterDialog(VerifyActivity.this,
                        "Are you sure you want"+"\n"+"signup with another"+"\n"+"phone number ?", new OnButtonClick() {
                            @Override
                            public void buttonClick() {
                                Intent intent = new Intent(getBaseContext(),NewPhoneNumberActivity.class);
                                startActivity(intent);
                            }
                        });
                break;
            case R.id.btn_verify_otp:
                Toast.makeText(getApplicationContext(), "Verification code sent successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(),PasswordActivity.class));
                break;

        }
    }
}