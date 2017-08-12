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
    private String[] titulo;

    public BaseViewPagerAdapter(FragmentManager manager, Context context, int redSocial, int texto) {
        super(manager);
        img = context.getResources().obtainTypedArray(redSocial);
        titulo = context.getResources().getStringArray(texto);
    }

    @Override
    public Fragment getItem(int position) {
    return BasicFragment.getInstance(img.getResourceId(position, 0), titulo[position]);
    }

    @Override
    public int getCount() {
       return img.length();
    }

}
