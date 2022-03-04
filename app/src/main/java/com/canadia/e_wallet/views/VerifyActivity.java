package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.OnButtonClick;
import com.canadia.e_wallet.helper.Tool;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class VerifyActivity extends AppCompatActivity {

    EditText first_otp,second_otp,third_otp,four_otp,five_otp,six_otp;
    Button verify_otp;
    TextView canadiaLink,timeCountdown,success_show;
    Spanned Text;
    String phone_number, d_box1 = "1",d_box2 = "1", d_box3 = "1",d_box4 = "1",d_box5 = "1", d_box6 = "1";


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

        // find id
        first_otp = findViewById(R.id.first_otp);
        second_otp = findViewById(R.id.second_otp);
        third_otp = findViewById(R.id.third_otp);
        four_otp = findViewById(R.id.four_otp);
        five_otp = findViewById(R.id.five_otp);
        six_otp = findViewById(R.id.six_otp);
        verify_otp = findViewById(R.id.btn_verify_otp);
        canadiaLink = findViewById(R.id.canadia_link);
        timeCountdown = findViewById(R.id.time_limit);
        success_show = findViewById(R.id.success_show);

        setCountdown();

        Text = Html.fromHtml("<a href=''>Change phone number</a>");
        canadiaLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tool.changePhoneDialog(VerifyActivity.this,
                        "Are you sure you want"+"\n"+"signup with another"+"\n"+"phone number ?", new OnButtonClick() {
                            @Override
                            public void buttonClick() {
                                Intent intent = new Intent(getBaseContext(),NewPhoneNumberActivity.class);
                                startActivity(intent);
                            }
                        });
            }
        });
        EditText[] edit = {first_otp,second_otp,third_otp,four_otp,five_otp,six_otp};

        first_otp.addTextChangedListener(new verifyTextWatcher(first_otp,edit));
        second_otp.addTextChangedListener(new verifyTextWatcher(second_otp,edit));
        third_otp.addTextChangedListener(new verifyTextWatcher(third_otp,edit));
        four_otp.addTextChangedListener(new verifyTextWatcher(four_otp,edit));
        five_otp.addTextChangedListener(new verifyTextWatcher(five_otp,edit));
        six_otp.addTextChangedListener(new verifyTextWatcher(six_otp,edit));


        verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String box1 = first_otp.getText().toString();
                String box2 = second_otp.getText().toString();
                String box3 = third_otp.getText().toString();
                String box4 = four_otp.getText().toString();
                String box5 = five_otp.getText().toString();
                String box6 = six_otp.getText().toString();
                if(d_box1.equals(box1) && d_box2.equals(box2) && d_box3.equals(box3) && d_box4.equals(box4) && d_box5.equals(box5) && d_box6.equals(box6)){
                    Toast.makeText(getApplicationContext(), "Verification code sent successfully", Toast.LENGTH_SHORT).show();
                    success_show.setVisibility(View.VISIBLE);
                    Intent next_intent = new Intent(getBaseContext(),PasswordActivity.class);
                    startActivity(next_intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Sorry please check your otp again!", Toast.LENGTH_SHORT).show();
                }

            }
        });
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

//    public void setCountDownTimer(long startCountdown) {
//        countDownTimer = new CountDownTimer(startCountdown, 1000) {
//            @SuppressLint("SetTextI18n")
//            public void onTick(long millisUntilFinished) {
//                timeCountdown.setText((millisUntilFinished / 1000) + " seconds");
//                GlobalShare.getInstance().millisContinue = millisUntilFinished;
////                Log.e("Timer: ", (millisUntilFinished / 1000) + " seconds");
//            }
//            public void onFinish() {
////                timeCountdown.setText("0");
////                finish();
//                Tool.showDialog(VerifyActivity.this, "Did not you receive verification code ? ","We call "+phone_number + " to read your verification code", new OnButtonClick() {
//                    @Override
//                    public void buttonClick() {
//                        setCountdown();
//                    }
//                });
//
//            }
//        }.start();
//    }

    public class verifyTextWatcher implements TextWatcher {
        private final EditText[] editText;
        private View view;
        public verifyTextWatcher(View view, EditText editText[])
        {
            this.editText = editText;
            this.view = view;
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            switch (view.getId()) {

                case R.id.first_otp:
                    if (text.length() == 1)
                        editText[1].requestFocus();
                    break;
                case R.id.second_otp:

                    if (text.length() == 1)
                        editText[2].requestFocus();
                    else if (text.length() == 0)
                        editText[0].requestFocus();
                    break;
                case R.id.third_otp:
                    if (text.length() == 1)
                        editText[3].requestFocus();
                    else if (text.length() == 0)
                        editText[1].requestFocus();
                    break;
                case R.id.four_otp:
                    if (text.length() == 1)
                        editText[4].requestFocus();
                    else if (text.length() == 0)
                        editText[2].requestFocus();
                    break;
                case R.id.five_otp:
                    if (text.length() == 1)
                        editText[5].requestFocus();
                    else if (text.length() == 0)
                        editText[3].requestFocus();
                    break;
                case R.id.six_otp:
                    if (text.length() == 0)
                        editText[6].requestFocus();
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            String box1 = first_otp.getText().toString().trim();
            String box2 = second_otp.getText().toString().trim();
            String box3 = third_otp.getText().toString().trim();
            String box4 = four_otp.getText().toString().trim();
            String box5 = five_otp.getText().toString().trim();
            String box6 = six_otp.getText().toString().trim();
            verify_otp.setEnabled(!box1.isEmpty() && !box2.isEmpty() && !box3.isEmpty() && !box4.isEmpty() && !box5.isEmpty() && !box6.isEmpty());
        }
    }
}