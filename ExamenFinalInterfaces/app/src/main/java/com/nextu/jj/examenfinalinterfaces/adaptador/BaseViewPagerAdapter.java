package com.nextu.jj.examenfinalinterfaces.adaptador;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nextu.jj.examenfinalinterfaces.BasicFragment;
import com.nextu.jj.examenfinalinterfaces.R;

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabs;

    public BaseViewPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        tabs = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        return BasicFragment.getInstance(tabs[position]);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
