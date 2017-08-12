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

    TextView textTab;
    ImageView imageTab;

    private int mCurrentImage;
    private String mCurrentText;

    private static final String ARG_IMAGE = "imagen";
    private static final String ARG_TEXT = "texto";

    public static BasicFragment getInstance(int imagen, String titulo) {
        BasicFragment fragment = new BasicFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARG_IMAGE, imagen);
        bundle.putString(ARG_TEXT, titulo);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null){
            this.mCurrentImage = savedInstanceState.getInt(ARG_IMAGE);
            this.mCurrentText = savedInstanceState.getString(ARG_TEXT, "Titulo");
        }

        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.imageTab= (ImageView) view.findViewById(R.id.image_tab);
        this.textTab = (TextView) view.findViewById(R.id.text_tab);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle arguments = getArguments();
        if (arguments != null)
            updateView(arguments.getInt(ARG_IMAGE), arguments.getString(ARG_TEXT, "Titulo"));
        else if (mCurrentImage != -1)
            updateView(mCurrentImage, mCurrentText);
    }

    private void updateView(int imagen, String titulo)
    {
        this.imageTab.setImageResource(imagen);
        this.textTab.setText(titulo);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_TEXT, mCurrentText);
        outState.putInt(ARG_IMAGE, mCurrentImage);
    }
}
