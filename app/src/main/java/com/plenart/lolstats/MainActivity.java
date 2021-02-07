package com.plenart.lolstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.plenart.lolstats.Adapters.ScreenSlideAdapter;
import com.plenart.lolstats.Fragments.ChampionsFragment;
import com.plenart.lolstats.Fragments.ItemsFragment;
import com.plenart.lolstats.Fragments.RunesFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        hideActionBar();
        setUpViewPager();
    }

    private void initViews() {
        title = findViewById(R.id.txtTitle);
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);
    }

    private void hideActionBar() {
       getSupportActionBar().hide();
    }

    private void setUpViewPager() {

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(ChampionsFragment.newInstance());
        fragmentList.add(ItemsFragment.newInstance());
        fragmentList.add(RunesFragment.newInstance());

        PagerAdapter pagerAdapter = new ScreenSlideAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

}