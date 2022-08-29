package com.peter.android.yisgitclient.fragment;

import android.os.Bundle;
import android.view.View;

import com.peter.android.yisgitclient.R;
import com.peter.android.yisgitclient.databinding.FragmentLoginBinding;

public class LoginPageFragment extends BasePageFragment {
    private static final String TAG = "LoginPageFragment";

    private FragmentLoginBinding mBinding;

    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void setViews(View view, Bundle savedInstanceState) {
        mBinding = FragmentLoginBinding.bind(view);
    }


}
