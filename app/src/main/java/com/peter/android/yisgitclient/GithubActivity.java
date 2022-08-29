package com.peter.android.yisgitclient;

import android.os.Bundle;
import android.util.Log;

import com.peter.android.yisgitclient.databinding.ActivityGithubBinding;
import com.peter.android.yisgitclient.util.Util;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
        test();
    }

    private void test() {
//        Util.getINSTANCE().getRetrofitService().fetchData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        Log.d("122334", s);
//                    }
//                });
    }
}
