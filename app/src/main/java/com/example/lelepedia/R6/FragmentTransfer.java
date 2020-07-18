package com.example.lelepedia.R6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lelepedia.R;

public class FragmentTransfer extends Fragment {
    View MyFragment;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MyFragment = inflater.inflate(R.layout.fragment_r6_transfer,container,false);

        tabLayout = MyFragment.findViewById(R.id.tab_r6);
        viewPager = MyFragment.findViewById(R.id.pager_r6);

        return MyFragment;
    }
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        viewPagerAdapter adapter = new viewPagerAdapter(getChildFragmentManager());

        adapter.AddFragment(new FragTambah(), "Tambah Player");
        adapter.AddFragment(new FragTransfer(), "Transfer Player");

        viewPager.setAdapter(adapter);
    }
}
