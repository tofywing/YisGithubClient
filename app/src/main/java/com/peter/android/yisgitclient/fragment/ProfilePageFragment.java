package com.peter.android.yisgitclient.fragment;

import android.os.Bundle;
import android.view.View;

import com.peter.android.yisgitclient.R;
import com.peter.android.yisgitclient.databinding.FragmentProfileBinding;

public class ProfilePageFragment extends BasePageFragment {
    private static final String TAG = "ProfilePageFragment";

    private FragmentProfileBinding mBinding;

    @Override
    protected int setLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void setViews(View view, Bundle savedInstanceState) {
        mBinding = FragmentProfileBinding.bind(view);
    }
}
