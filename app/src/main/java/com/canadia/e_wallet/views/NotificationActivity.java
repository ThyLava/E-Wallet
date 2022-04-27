package com.canadia.e_wallet.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.canadia.e_wallet.R;
import com.canadia.e_wallet.adapter.RecyclerViewAdapter;
import com.canadia.e_wallet.helper.SwipeToDeleteCallback;
import com.canadia.e_wallet.models.notificationModel;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;
    ArrayList<notificationModel> stringArrayList = new ArrayList<>();
    ConstraintLayout constraintLayout;
    Button btn_transfer_next;
    ImageView action_back;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_notification);
        getToolbar();

        recyclerView = findViewById(R.id.recyclerView);
        constraintLayout = findViewById(R.id.constraintLayout);

        populateRecyclerView();
        getCurrentDate();
        enableSwipeToDeleteAndUndo();
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
        title.setText("Notifications");
    }
    public String getCurrentDate(){
        String new_date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        return new_date;
    }
    private void populateRecyclerView() {
        stringArrayList.add(new notificationModel("electricity",getCurrentDate(),"electric",R.drawable.eletric,0));
        stringArrayList.add(new notificationModel("Chicken POP",getCurrentDate(),"food",R.drawable.food,1));
        stringArrayList.add(new notificationModel("electricity",getCurrentDate(),"electric",R.drawable.power,2));
        stringArrayList.add(new notificationModel("Chicken POP",getCurrentDate(),"food",R.drawable.payment,1));
        stringArrayList.add(new notificationModel("electricity",getCurrentDate(),"electric",R.drawable.wallet,2));
        stringArrayList.add(new notificationModel("Chicken POP",getCurrentDate(),"food",R.drawable.wifi,0));
        stringArrayList.add(new notificationModel("electricity",getCurrentDate(),"electric",R.drawable.shop,1));
        stringArrayList.add(new notificationModel("Chicken POP",getCurrentDate(),"food",R.drawable.home,0));
        stringArrayList.add(new notificationModel("electricity",getCurrentDate(),"electric",R.drawable.favorite,1));
        stringArrayList.add(new notificationModel("Chicken POP",getCurrentDate(),"food",R.drawable.gift,2));
        stringArrayList.add(new notificationModel("electricity",getCurrentDate(),"electric",R.drawable.movie,1));
        stringArrayList.add(new notificationModel("Chicken POP",getCurrentDate(),"food",R.drawable.bill,0));


        mAdapter = new RecyclerViewAdapter(stringArrayList,this);
        recyclerView.setAdapter(mAdapter);



    }

    private void enableSwipeToDeleteAndUndo() {

        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


                final int position = viewHolder.getAdapterPosition();
                final notificationModel item = mAdapter.getData().get(position);

                mAdapter.removeItem(position);


                Snackbar snackbar = Snackbar
                        .make(constraintLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mAdapter.restoreItem(item, position);
                        recyclerView.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }

}