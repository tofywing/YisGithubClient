package com.peter.android.yisgitclient.util;

public class AppConfig {
    public final static String BASE_URL = "https://github.com/";
    public final static String OAUTH2_URL = BASE_URL + "login/oauth/authorize";
    public final static String OAUTH2_SCOPE = "user,repo,gist,notifications";
    public final static String GITHUB_CLIENT_ID = "Iv1.e14dd909976757a7";
    public final static String GITHUB_SECRETS = "27ce907801573763b7aa0c9066bfe2d92da1f00d";
    public final static int HTTP_TIME_OUT = 32 * 1000;
    public final static int HTTP_MAX_CACHE_SIZE = 32 * 1024 * 1024;
    public static final String REDIRECT_URL = "githubclient/login";
}
