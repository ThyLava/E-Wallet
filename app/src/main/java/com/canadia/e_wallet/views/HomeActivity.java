package com.canadia.e_wallet.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.MainActivity;
import com.canadia.e_wallet.R;
import com.canadia.e_wallet.helper.OnButtonClick;
import com.canadia.e_wallet.adapter.PayGridViewAdapter;
import com.canadia.e_wallet.helper.ShareInstance;
import com.canadia.e_wallet.models.PayModel;
import com.canadia.e_wallet.helper.Tool;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

//    Double default_balance = 100.95;
    GridView pay_view;
    BottomNavigationView nav;
    ImageView sign_out,notification,show_balance;
    TextView balance;
    boolean isShow = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_home);

//        ShareInstance.TotalBalance =  default_balance;


        bindViewByID();
        payData();
        slideData();

        notification.setOnClickListener(this);
        show_balance.setOnClickListener(this);
        sign_out.setOnClickListener(this);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.shop, R.id.home,R.id.favorite)
                .build();
    }
    // bind view by id
    public void bindViewByID(){
        pay_view = findViewById(R.id.grid_pay);
        sign_out = findViewById(R.id.btn_close_app);
        notification = findViewById(R.id.notification);
        show_balance = findViewById(R.id.show);
        balance = findViewById(R.id.balance);
        nav = findViewById(R.id.bottom_navigation);

    }



    private void payData(){
        ArrayList<PayModel> payModelArrayList = new ArrayList<PayModel>();

        payModelArrayList.add(new PayModel("Transfer", R.drawable.transfer));
        payModelArrayList.add(new PayModel("Food Delivery ", R.drawable.food));
        payModelArrayList.add(new PayModel("Friends", R.drawable.group));
        payModelArrayList.add(new PayModel("All Services", R.drawable.dot));
        payModelArrayList.add(new PayModel("Give Gifts", R.drawable.gift));
        payModelArrayList.add(new PayModel("Movie Tickets", R.drawable.movie));
        payModelArrayList.add(new PayModel("Order Coffee", R.drawable.ic_baseline_coffee_24));
        payModelArrayList.add(new PayModel("Pay Bills", R.drawable.bill));
        PayGridViewAdapter adapter = new PayGridViewAdapter(this, payModelArrayList);
        pay_view.setAdapter(adapter);
        pay_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Intent i = new Intent(getApplicationContext(), TransferFundActivity.class);
                        startActivity(i);
                        break;
                    } case 1:{
                        Intent i = new Intent(getApplicationContext(), FoodActivity.class);
                        startActivity(i);
                        break;
                    } case 7: {
                        Intent i = new Intent(getApplicationContext(), PayBillActivity.class);
                        startActivity(i);
                        break;
                    }
                    default:
                        break;
                }

            }
        });
    }

    private void slideData(){
        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://global-uploads.webflow.com/5ee6fcad61bab357cf10c8fa/623d4461d6af6a2a19561b9d_VISA-EDUCATION.jpg"));
        slideModels.add(new SlideModel("https://global-uploads.webflow.com/5ee6fcad61bab357cf10c8fa/61fddef80f8059746744f21e_CNB_FIX_DEPOSIT_PROMO_Web.jpg"));
        slideModels.add(new SlideModel("https://global-uploads.webflow.com/5ee6fcad61bab357cf10c8fa/5f8d17f846544fa02a1b7e4d_resize%20for%20website-04.png"));
        slideModels.add(new SlideModel("https://global-uploads.webflow.com/5ee6fcad61bab357cf10c8fa/6244018829da6bcdb0cc7d85_e-Voucher-%242-from-Legend-Web.jpg"));
        slideModels.add(new SlideModel("https://global-uploads.webflow.com/5ee6fcad61bab357cf10c8fa/5f8e4d12f19506366a5c86cf_Promotion%20thumnail%201200px%20X%20650px-03.jpg"));
        imageSlider.setImageList(slideModels,true);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show:
                isShow = !isShow;
                show_balance.setSelected(isShow);
                balance.setText(isShow?"$ "+ ShareInstance.TotalBalance.toString():"*****");
                show_balance.setImageResource(isShow?R.drawable.ic_baseline_visibility_24 : R.drawable.visibility_off);
                break;
            case R.id.notification:
                startActivity(new Intent(getApplicationContext(),NotificationActivity.class));
                break;
            case R.id.btn_close_app:
                Tool.threeParameterDialog(HomeActivity.this, "Are you sure you want to sign out ?", new OnButtonClick() {
                    @Override
                    public void buttonClick() {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                });
                break;

        }

    }

    @Override
    public void  onResume() {
        super.onResume();

//        isShow = !isShow;
//        show_balance.setSelected(isShow);
//        balance.setText(isShow?"$ "+ ShareInstance.TotalBalance.toString():"*****");
//        show_balance.setImageResource(isShow?R.drawable.ic_baseline_visibility_24: R.drawable.visibility_off);
//
    }

}