package com.peter.android.yisgitclient.util;

import com.peter.android.yisgitclient.AppData;
import com.peter.android.yisgitclient.network.IssueService;
import com.peter.android.yisgitclient.network.LoginService;
import com.peter.android.yisgitclient.network.RepoService;
import com.peter.android.yisgitclient.network.RetrofitClient;
import com.peter.android.yisgitclient.network.RetrofitService;
import com.peter.android.yisgitclient.network.SearchService;
import com.peter.android.yisgitclient.network.UserService;

public class RetrofitUtil {
    private static final RetrofitUtil INSTANCE = new RetrofitUtil();

    public static RetrofitUtil getINSTANCE() {
        return INSTANCE;
    }

    private RetrofitUtil() {
    }

    protected LoginService getLoginService() {
        return RetrofitClient.getINSTANCE()
                .getRetrofit(AppConfig.BASE_URL, null)
                .create(LoginService.class);
    }

    protected LoginService getLoginService(String token) {
        return RetrofitClient.getINSTANCE()
                .getRetrofit(AppConfig.BASE_URL, token)
                .create(LoginService.class);
    }

    protected UserService getUserService(String token) {
        return RetrofitClient.getINSTANCE()
                .getRetrofit(AppConfig.BASE_URL, token)
                .create(UserService.class);
    }

    protected UserService getUserService() {
        return getUserService(AppData.INSTANCE.getAccessToken());
    }

    protected RepoService getRepoService() {
        return getServices(RepoService.class);
    }

    protected SearchService getSearchService() {
        return getServices(SearchService.class);
    }

    protected IssueService getIssueService() {
        return getServices(IssueService.class);
    }

    private <T> T getServices(Class<T> serviceClass) {
        return getServices(serviceClass, AppConfig.BASE_URL, true);
    }

    protected <T> T getServices(Class<T> serviceClass, String baseUrl, boolean isJson) {
        return RetrofitClient.getINSTANCE()
                .getRetrofit(baseUrl, AppData.INSTANCE.getAccessToken(), isJson)
                .create(serviceClass);
    }
}
