package com.example.lutemon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemon.fragments.BattleFieldFragment;
import com.example.lutemon.fragments.HomeFragment;
import com.example.lutemon.fragments.TrainFieldFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<String> listOfTitles;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<String> listOfTitles) {
        super(fragmentActivity);
        this.listOfTitles = listOfTitles;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new TrainFieldFragment();
            case 2:
                return new BattleFieldFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return listOfTitles.size();
    }

    public void updateFragments(){

        new HomeFragment();
        new TrainFieldFragment();
        new BattleFieldFragment();

    }
}
