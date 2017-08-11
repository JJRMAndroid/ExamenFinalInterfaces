package com.nextu.jj.examenfinalinterfaces.adaptador;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nextu.jj.examenfinalinterfaces.BasicFragment;
import com.nextu.jj.examenfinalinterfaces.R;

public class BaseViewPagerAdapter extends FragmentStatePagerAdapter {

    private TypedArray img;

    public BaseViewPagerAdapter(FragmentManager manager, Context context, int redSocial) {
        super(manager);
        img = context.getResources().obtainTypedArray(redSocial);
    }

    @Override
    public Fragment getItem(int position) {
    return BasicFragment.getInstance(img.getResourceId(position, 0));
    }

    @Override
    public int getCount() {
       return img.length();
    }

}
