package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.adapter.BankGridViewAdapter;
import com.canadia.e_wallet.adapter.PayGridViewAdapter;
import com.canadia.e_wallet.models.BankModel;
import com.canadia.e_wallet.models.PayModel;

import java.util.ArrayList;

public class PayBillActivity extends AppCompatActivity {
    ImageView action_back;
    TextView title;
    GridView bills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_pay_bill);
        getToolbar();
        bills = findViewById(R.id.grid_bill);
        billData();
        bills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 5:
                        startActivity(new Intent(getBaseContext(),ListBankActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void getToolbar() {
        title = findViewById(R.id.app_title_bar);
        action_back = findViewById(R.id.back);
        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        title.setText("Pay Bills");
    }
    private void billData(){
        ArrayList<BankModel> bankModelArrayList = new ArrayList<BankModel>();

        bankModelArrayList.add(new BankModel("Payment", R.drawable.payment));
        bankModelArrayList.add(new BankModel("Internet", R.drawable.wifi));
        bankModelArrayList.add(new BankModel("All Services", R.drawable.dot_pay));
        bankModelArrayList.add(new BankModel("Airport", R.drawable.ic_baseline_connecting_airports_24));
        bankModelArrayList.add(new BankModel("Phone", R.drawable.ic_baseline_phone_iphone_24));
        bankModelArrayList.add(new BankModel("Electricity", R.drawable.eletric));
        bankModelArrayList.add(new BankModel("Watch", R.drawable.watch));
        bankModelArrayList.add(new BankModel("Food & Drink", R.drawable.food_drink));

        BankGridViewAdapter adapter = new BankGridViewAdapter(this, bankModelArrayList);
        bills.setAdapter(adapter);
    }
}