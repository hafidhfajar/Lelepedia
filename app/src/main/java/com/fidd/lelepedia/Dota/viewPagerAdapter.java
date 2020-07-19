package com.fidd.lelepedia.Dota;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class viewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> frag1 = new ArrayList<>();
    private final List<String> title1 = new ArrayList<>();


    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        return frag1.get(position);
    }

    @Override
    public int getCount() {
        return title1.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title1.get(position);
    }


    public void AddFragment (Fragment fragment, String title){

        frag1.add(fragment);
        title1.add(title);

    }
}

