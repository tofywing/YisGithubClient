package com.peter.android.yisgitclient;

import android.content.Intent;
import android.os.Bundle;

import com.peter.android.yisgitclient.databinding.ActivityGithubBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class GithubActivity extends AppCompatActivity {
    private static final String TAG = "GithubActivity";

    private ActivityGithubBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityGithubBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setSupportActionBar(mBinding.toolBar);
        NavController navController = new NavController(this);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(R.navigation.nav_graph).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        startActivity(new Intent(this, LoginActivity.class));
    }
}
