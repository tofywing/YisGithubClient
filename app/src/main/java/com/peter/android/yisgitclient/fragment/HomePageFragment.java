package com.peter.android.yisgitclient.fragment;

import android.os.Bundle;
import android.view.View;

import com.peter.android.yisgitclient.R;
import com.peter.android.yisgitclient.databinding.FragmentHomeBinding;

public class HomePageFragment extends BasePageFragment {
    private static final String TAG = "HomePageFragment";

    private FragmentHomeBinding mBinding;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setViews(View view, Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.bind(view);
    }
}
