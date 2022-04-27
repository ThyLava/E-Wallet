package com.canadia.e_wallet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.canadia.e_wallet.views.PasswordActivity;
import com.canadia.e_wallet.views.SignUpActivity;
import com.canadia.e_wallet.views.TransactionDetailActivity;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

  private ViewPager viewPager;
  private Button button, btn_register;
  private SliderPagerAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // making activity full screen
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().getDecorView()
          .setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
    setContentView(R.layout.activity_main);
    // hide action bar you can use NoAction theme as well
    getSupportActionBar().hide();
    // bind views
    viewPager = findViewById(R.id.pagerIntroSlider);
    TabLayout tabLayout = findViewById(R.id.tabs);
    button = findViewById(R.id.button);
    btn_register = findViewById(R.id.btn_register);

    // init slider pager adapter
    adapter = new SliderPagerAdapter(getSupportFragmentManager(),
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

    // set adapter
    viewPager.setAdapter(adapter);

    // set dot indicators
    tabLayout.setupWithViewPager(viewPager);

    // make status bar transparent
    changeStatusBarColor();

    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (viewPager.getCurrentItem() < adapter.getCount()-1) {
          viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }else{
            Intent next_intent = new Intent(getBaseContext(), SignUpActivity.class);
            startActivity(next_intent);
        }

      }
    });

    btn_register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent next_intent = new Intent(getBaseContext(), PasswordActivity.class);
        startActivity(next_intent);
      }
    });

    /**
     * Add a listener that will be invoked whenever the page changes
     * or is incrementally scrolled
     */
    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }
      @Override public void onPageSelected(int position) {
        if (position == adapter.getCount() - 1) {
          button.setText("Login");

        } else {
          button.setText(R.string.next);
        }
      }

      @Override public void onPageScrollStateChanged(int state) {

      }
    });
  }

  private void changeStatusBarColor() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window window = getWindow();
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.setStatusBarColor(Color.TRANSPARENT);
    }
  }
}
