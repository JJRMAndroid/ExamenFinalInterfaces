package com.nextu.jj.examenfinalinterfaces;

/**
 * Created by JJ on 8/4/2017.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public TabAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new FacebooklFragment();
            case 1: return new FacebooklFragment();
            case 2: return new FacebooklFragment();
            case 3: return new FacebooklFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return context.getString(R.string.seccion1);
            case 1: return context.getString(R.string.seccion1);
            case 2: return context.getString(R.string.seccion1);
            case 3: return context.getString(R.string.seccion1);
        }
        return super.getPageTitle(position);
    }
}
