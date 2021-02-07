package com.plenart.lolstats.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ScreenSlideAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 3;
    private List<Fragment> mFragmentList;

    public ScreenSlideAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mFragmentList = fragmentList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if(position == 0)
            return "Champions";
        else
            if(position == 1)
                return "Items";
        else
            return  "Runes";
    }
}
