

package com.peter.android.yisgitclient;

import android.app.Application;
import android.content.Context;

/**
 * AppApplication
 * Created by ThirtyDegreesRay on 2016/7/13 14:01
 */
public class AppApplication extends Application {

    private final String TAG = AppApplication.class.getSimpleName();

    private static AppApplication application;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static AppApplication get(){
        return application;
    }
}
