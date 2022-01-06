package com.example.chillersmarket.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> tabsList = new ArrayList<>();
    private final ArrayList<String> tabsTitleList = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabsList.get(position);
    }

    @Override
    public int getCount() {
        return tabsList.size();
    }

    public void addFragment(Fragment fragment, String title){
        tabsList.add(fragment);
        tabsTitleList.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabsTitleList.get(position);
    }
}
