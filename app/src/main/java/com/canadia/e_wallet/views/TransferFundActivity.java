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
import com.canadia.e_wallet.models.BankModel;

import java.util.ArrayList;

public class TransferFundActivity extends AppCompatActivity {
    ImageView action_back;
    TextView title;
    GridView banks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_transfer_fund);
        getToolbar();
        banks = findViewById(R.id.grid_bank);
        bankData();
    }
    private void bankData(){
        ArrayList<BankModel> bankModelArrayList = new ArrayList<BankModel>();
        bankModelArrayList.add(new BankModel("Canadia", R.drawable.canadia));
        bankModelArrayList.add(new BankModel("Wing", R.drawable.wing));
        bankModelArrayList.add(new BankModel("ACLEDA", R.drawable.acleda));
        bankModelArrayList.add(new BankModel("ABA", R.drawable.aba));
        bankModelArrayList.add(new BankModel("AMK", R.drawable.amk));
        bankModelArrayList.add(new BankModel("Amret", R.drawable.amret));
        bankModelArrayList.add(new BankModel("Vatanac", R.drawable.vattanac));
        bankModelArrayList.add(new BankModel("Shinhan", R.drawable.shinhan));
        bankModelArrayList.add(new BankModel("SHB", R.drawable.shb));
        bankModelArrayList.add(new BankModel("SATHAPANA", R.drawable.sathapana));
        bankModelArrayList.add(new BankModel("RHB Indochina ", R.drawable.rhb));
        bankModelArrayList.add(new BankModel("PRINCE",R.drawable.prince));
        bankModelArrayList.add(new BankModel("PHILLIP ",R.drawable.phillip));
        bankModelArrayList.add(new BankModel("Chip Mong",R.drawable.chipmong));
        bankModelArrayList.add(new BankModel("Cambodian Public ",R.drawable.cambodian));
        BankGridViewAdapter adapter = new BankGridViewAdapter(this, bankModelArrayList);
        banks.setAdapter(adapter);
        banks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), TransferToActivity.class);
                i.putExtra("name",bankModelArrayList.get(position).getBank_name());
                i.putExtra("img",bankModelArrayList.get(position).getBank_image());
                startActivity(i);
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
        title.setText("Transfer To ...");
    }
}