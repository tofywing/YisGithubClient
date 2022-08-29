package com.peter.android.yisgitclient.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("users/mralexgray/repos")
    Observable<List<String>> fetchData();
}
