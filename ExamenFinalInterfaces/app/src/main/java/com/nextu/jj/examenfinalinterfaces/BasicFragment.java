package com.nextu.jj.examenfinalinterfaces;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BasicFragment extends Fragment {

    TextView textTab;

    private String mCurrentTitle;

    private static final String ARG_TITLE = "title";

    public static BasicFragment getInstance(String title) {
        BasicFragment fragment = new BasicFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null)
            this.mCurrentTitle = savedInstanceState.getString(ARG_TITLE);
        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.textTab = (TextView) view.findViewById(R.id.text_tab);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle arguments = getArguments();
        if (arguments != null)
            updateView(arguments.getString(ARG_TITLE));
        else if (mCurrentTitle != null)
            updateView(mCurrentTitle);
    }

    private void updateView(String title) {
        this.textTab.setText(title);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ARG_TITLE, mCurrentTitle);
    }
}
