package com.peter.android.yisgitclient.util;

import com.peter.android.yisgitclient.network.RetrofitClient;
import com.peter.android.yisgitclient.network.RetrofitService;

public class Util {
    private static final Util INSTANCE = new Util();

    public static Util getINSTANCE() {
        return INSTANCE;
    }

    private Util() {
    }

    public RetrofitService getRetrofitService() {
        return RetrofitClient.getINSTANCE().getRetrofit(AppConfig.BASE_URL).create(RetrofitService.class);
    }
}
