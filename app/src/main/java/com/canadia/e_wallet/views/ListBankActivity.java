package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.adapter.Adapter;
import com.canadia.e_wallet.models.Model;

import java.util.ArrayList;
import java.util.List;

public class ListBankActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Model> list=new ArrayList<>();
    Adapter adapter;
    ImageView action_back;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_list_bank);
        getToolbar();
        addData();

        recyclerView= findViewById(R.id.banks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,list,list.size());
        recyclerView.setAdapter(adapter);
    }
    // list banks for payment
    private void addData() {
        list.add(new Model(R.drawable.canadia,"Canadia","free recharge"));
        list.add(new Model(R.drawable.wing,"Wing","free recharge"));
        list.add(new Model(R.drawable.aba,"ABA","free recharge"));
        list.add(new Model(R.drawable.amk,"AMK","free recharge"));
        list.add(new Model(R.drawable.acleda,"ACLEDA","free recharge"));
        list.add(new Model(R.drawable.amret,"Amret","free recharge"));
        list.add(new Model(R.drawable.sathapana,"SATHAPANA","free recharge"));
        list.add(new Model(R.drawable.phillip,"Phillip","free recharge"));
        list.add(new Model(R.drawable.shb,"SHB","free recharge"));
        list.add(new Model(R.drawable.shinhan,"Shinhan","free recharge"));
        list.add(new Model(R.drawable.rhb,"RHB","free recharge"));
        list.add(new Model(R.drawable.prince,"PRINCE","free recharge"));
        list.add(new Model(R.drawable.chipmong,"Chip Mong","free recharge"));
        list.add(new Model(R.drawable.cambodian,"Cambodian Public","free recharge"));
        list.add(new Model(R.drawable.vattanac,"VATTANAC","free recharge"));
    }

    // action bar
    private void getToolbar() {
        title = findViewById(R.id.app_title_bar);
        action_back = findViewById(R.id.back);
        action_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        title.setText("Electricity Payment ");
    }
}