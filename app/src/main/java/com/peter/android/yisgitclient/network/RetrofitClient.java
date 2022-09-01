package com.peter.android.yisgitclient.network;

import com.peter.android.yisgitclient.AppApplication;
import com.peter.android.yisgitclient.util.AppConfig;
import com.peter.android.yisgitclient.util.FileUtil;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;;

public class RetrofitClient {
    private static final RetrofitClient INSTANCE = new RetrofitClient();

    public static RetrofitClient getINSTANCE() {
        return INSTANCE;
    }

    private final HashMap<String, Retrofit> retrofitMap;
    private String token;

    private RetrofitClient() {
        retrofitMap = new HashMap<>();
    }

    private void createRetrofit(String baseUrl, boolean isJson) {
        int timeOut = AppConfig.HTTP_TIME_OUT;
        Cache cache = new Cache(FileUtil.getHttpImageCacheDir(AppApplication.get()),
                AppConfig.HTTP_MAX_CACHE_SIZE);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.MILLISECONDS)
                .cache(cache)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);

        if (isJson) {
            builder.addConverterFactory(GsonConverterFactory.create());
        } else {
            //JAXB doesn't support Android so use the deprecated SimpleXmlConverterFactory.
            builder.addConverterFactory(SimpleXmlConverterFactory.createNonStrict());
        }

        retrofitMap.put(baseUrl + "-" + isJson, builder.build());
    }
    /**
     * By default the json is supported.
     */
    public Retrofit getRetrofit(@NonNull String baseUrl, @Nullable String token) {
        return getRetrofit(baseUrl, token, true);
    }
    public Retrofit getRetrofit(@NonNull String baseUrl, @Nullable String token, boolean isJson) {
        this.token = token;
        String key = baseUrl + "-" + isJson;
        if (!retrofitMap.containsKey(key)) {
            createRetrofit(baseUrl, isJson);
        }
        return retrofitMap.get(key);
    }


}
