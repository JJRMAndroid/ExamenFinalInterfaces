package com.nextu.jj.examenfinalinterfaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BasicFragment extends Fragment {

    //TextView textTab;
    ImageView imageTab;

    private int mCurrentImage;

    private static final String ARG_IMAGE = "imagen";

    public static BasicFragment getInstance(int imagen) {
        BasicFragment fragment = new BasicFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARG_IMAGE, imagen);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null)
            this.mCurrentImage = savedInstanceState.getInt(ARG_IMAGE);
        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.imageTab= (ImageView) view.findViewById(R.id.image_tab);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle arguments = getArguments();
        if (arguments != null)
            updateView(arguments.getInt(ARG_IMAGE));
        else if (mCurrentImage != -1)
            updateView(mCurrentImage);
    }

    private void updateView(int imagen)
    {
        this.imageTab.setImageResource(imagen);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString(ARG_TITLE, mCurrentTitle);
        outState.putInt(ARG_IMAGE, mCurrentImage);
    }
}
