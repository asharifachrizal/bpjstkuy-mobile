package com.example.asharifachrizal.BPJSTKUY._slider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class SliderPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "SliderPagerAdapter";
    List<Fragment> mListFragment;

    public SliderPagerAdapter(FragmentManager fm, List<Fragment> mListFragment) {
        super(fm);
        this.mListFragment = mListFragment;
    }

    @Override
    public Fragment getItem(int i) {
        int index = i % mListFragment.size();
        return SliderFragment.newInstance(mListFragment.get(index).getArguments().getString("params"));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
