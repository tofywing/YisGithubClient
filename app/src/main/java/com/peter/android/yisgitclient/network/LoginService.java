package com.peter.android.yisgitclient.network;

import com.peter.android.yisgitclient.model.AuthRequestModel;
import com.peter.android.yisgitclient.model.BasicToken;
import com.peter.android.yisgitclient.model.OauthToken;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {

 @POST("authorizations")
 @Headers("Accept: application/json")
 Observable<Response<BasicToken>> authorizations(
         @NonNull @Body AuthRequestModel authRequestModel
 );

 @POST("login/oauth/access_token")
 @Headers("Accept: application/json")
 Observable<Response<OauthToken>> getAccessToken(
         @Query("client_id") String clientId,
         @Query("client_secret") String clientSecret,
         @Query("code") String code,
         @Query("state") String state
 );
}

