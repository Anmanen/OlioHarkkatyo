package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;
import com.example.lutemon.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class TransferLutemonsActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;

    private ArrayList<String> listOfTitles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_lutemons);

        loadTitles();

        tabLayout = findViewById(R.id.tlFields);
        viewPager = findViewById(R.id.vpTabs);
        viewPager.setUserInputEnabled(true);
        viewPagerAdapter = new ViewPagerAdapter(this, listOfTitles);
        viewPager.setAdapter(viewPagerAdapter);
        //addTabLayoutMediator();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                viewPagerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }
    private void loadTitles() {

        listOfTitles.add("Kotix");
        listOfTitles.add("Treenix");
        listOfTitles.add("Taistelux");
    }

    private void addTabLayoutMediator() {
        TabLayoutMediator tbmediator = new TabLayoutMediator(tabLayout,viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override public void onConfigureTab(TabLayout.Tab tab, int position) {
                tab.setText(listOfTitles.get(position));
            }
        });
        tbmediator.attach();

    }

    public ViewPager2 getViewPager() {
        return viewPager;
    }
}