package com.peter.android.yisgitclient.network;

import com.peter.android.yisgitclient.model.Issue;
import com.peter.android.yisgitclient.model.Repository;
import com.peter.android.yisgitclient.model.SearchResult;
import com.peter.android.yisgitclient.model.User;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SearchService {

 @NonNull
 @GET("search/users")
 Observable<Response<SearchResult<User>>> searchUsers(
         @Query(value = "q", encoded = true) String query,
         @Query("sort") String sort,
         @Query("order") String order,
         @Query("page") int page
 );

 @NonNull @GET("search/repositories")
 Observable<Response<SearchResult<Repository>>> searchRepos(
         @Query(value = "q", encoded = true) String query,
         @Query("sort") String sort,
         @Query("order") String order,
         @Query("page") int page
 );

 @NonNull @GET("search/issues")
 @Headers("Accept: application/vnd.github.html,application/vnd.github.VERSION.raw")
 Observable<Response<SearchResult<Issue>>> searchIssues(
         @Header("forceNetWork") boolean forceNetWork,
         @Query(value = "q", encoded = true) String query,
         @Query("sort") String sort,
         @Query("order") String order,
         @Query("page") int page
 );

}
