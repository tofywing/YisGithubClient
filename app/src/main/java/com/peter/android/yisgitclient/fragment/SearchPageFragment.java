package com.peter.android.yisgitclient.fragment;

import android.os.Bundle;
import android.view.View;

import com.peter.android.yisgitclient.R;
import com.peter.android.yisgitclient.databinding.FragmentSearchBinding;

public class SearchPageFragment extends BasePageFragment {
    private static final String TAG = "SearchPageFragment";

    private FragmentSearchBinding mBinding;

    @Override
    protected int setLayout() {
        return R.layout.fragment_search;
    }

    @Override
    protected void setViews(View view, Bundle savedInstanceState) {
        mBinding = FragmentSearchBinding.bind(view);
    }
}
