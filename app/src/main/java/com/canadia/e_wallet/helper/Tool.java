package com.canadia.e_wallet.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.views.WelcomeActivity;

public class Tool {

    public static void showDialog(Activity activity, String title,String desc, final OnButtonClick onButtonClick ) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dealine_otp_dialog);
        TextView main_title = (TextView) dialog.findViewById(R.id.title);
        main_title.setText(title);
        TextView description = (TextView) dialog.findViewById(R.id.description);
        description.setText(desc);

        final Button closeDialog = (Button) dialog.findViewById(R.id.btn_close);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
//                onButtonClick.buttonClick();
            }
        });
        final Button callDialog = (Button) dialog.findViewById(R.id.btn_resend);
        callDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClick.buttonClick();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public static void threeParameterDialog(Activity activity, String title, final OnButtonClick onButtonClick ) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.change_phone_dialog);
        TextView main_title = (TextView) dialog.findViewById(R.id.main_title);
        main_title.setText(title);

        final Button closeDialog = (Button) dialog.findViewById(R.id.btn_cancel);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();

            }
        });
        final Button callDialog = (Button) dialog.findViewById(R.id.btn_yes);
        callDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                onButtonClick.buttonClick();
            }
        });

        dialog.show();

    }

    public static void confirmNexPhoneDialog(Activity activity, String title,String m,String desc, final OnButtonClick onButtonClick ) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.confirm_new_phone_dialog);
        TextView main_title = (TextView) dialog.findViewById(R.id.new_phone_title);
        main_title.setText(title);
        TextView main = (TextView) dialog.findViewById(R.id.main);
        main.setText(m);
        TextView description = (TextView) dialog.findViewById(R.id.new_phone_desc);
        description.setText(desc);

        final Button closeDialog = (Button) dialog.findViewById(R.id.btn_cancel_confirm);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
//                onButtonClick.buttonClick();
            }
        });
        final Button callDialog = (Button) dialog.findViewById(R.id.btn_next_confirm);
        callDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                onButtonClick.buttonClick();
            }
        });

        dialog.show();

    }

    public static void loginChoice(Activity activity, int logo, String title, String desc, final OnButtonClick onButtonClick ) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.login_dialog);

        ImageView logo_choose = (ImageView) dialog.findViewById(R.id.your_choice);
        logo_choose.setImageResource(logo);

        TextView main_title = (TextView) dialog.findViewById(R.id.title);
        main_title.setText(title);

        TextView description = (TextView) dialog.findViewById(R.id.description);
        description.setText(desc);

        final Button closeDialog = (Button) dialog.findViewById(R.id.btn_login_cancel);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
