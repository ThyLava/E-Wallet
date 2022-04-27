package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import com.canadia.e_wallet.adapter.BillGridViewAdapter;
import com.canadia.e_wallet.models.BillModel;

import java.util.ArrayList;

public class PayBillActivity extends AppCompatActivity {
    ImageView action_back;
    TextView title;
    CardView electricity_payment;
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

        ArrayList<BillModel> billModelArrayList = new ArrayList<BillModel>();

        billModelArrayList.add(new BillModel("Payment", R.drawable.payment));
        billModelArrayList.add(new BillModel("Internet", R.drawable.wifi));
        billModelArrayList.add(new BillModel("All Services", R.drawable.dot));
        billModelArrayList.add(new BillModel("Airport", R.drawable.ic_baseline_connecting_airports_24));
        billModelArrayList.add(new BillModel("Phone", R.drawable.ic_baseline_phone_iphone_24));
        billModelArrayList.add(new BillModel("Electricity", R.drawable.eletric));
        billModelArrayList.add(new BillModel("Watch", R.drawable.watch));
        billModelArrayList.add(new BillModel("Food & Drink", R.drawable.food));

        BillGridViewAdapter adapter = new BillGridViewAdapter(this, billModelArrayList);
        bills.setAdapter(adapter);
        bills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 5:
                        Intent i = new Intent(getApplicationContext(), ListBankActivity.class);
                        startActivity(i);
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
}