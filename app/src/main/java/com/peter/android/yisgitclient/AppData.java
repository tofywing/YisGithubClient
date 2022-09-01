package com.peter.android.yisgitclient;

import com.peter.android.yisgitclient.model.AuthUser;
import com.peter.android.yisgitclient.model.User;

import java.util.Locale;

import androidx.annotation.Nullable;

public enum AppData {
    INSTANCE;

    User loggedUser;
    AuthUser authUser;

    Locale systemDefaultLocal;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    @Nullable
    public String getAccessToken() {
        return authUser == null ? null : authUser.getAccessToken();
    }

    public Locale getSystemDefaultLocal() {
        if (systemDefaultLocal == null) {
            systemDefaultLocal = Locale.getDefault();
        }
        return systemDefaultLocal;
    }

}
