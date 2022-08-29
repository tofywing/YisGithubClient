package com.peter.android.yisgitclient.fragment;

import android.os.Bundle;
import android.view.View;

import com.peter.android.yisgitclient.R;
import com.peter.android.yisgitclient.databinding.FragmentErrorBinding;

public class ErrorPageFragment extends BasePageFragment {
    private static final String TAG = "ErrorPageFragment";

    private FragmentErrorBinding mBinding;

    @Override
    protected int setLayout() {
        return R.layout.fragment_error;
    }

    @Override
    protected void setViews(View view, Bundle savedInstanceState) {
        mBinding = FragmentErrorBinding.bind(view);
    }
}
