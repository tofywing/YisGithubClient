

package com.peter.android.yisgitclient.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.peter.android.yisgitclient.AppApplication;

import java.util.Set;

import androidx.annotation.NonNull;

/**
 * Created on 2017/10/30 11:59:38
 * Copied from Copyright (C) 2017 Kosh.
 * Modified by Copyright (C) 2017 ThirtyDegreesRay.
 */

public class PrefUtils {

    public final static String LIGHT_INDIGO = "Light indigo";
    public final static String DARK = "Dark";
    public final static String LIGHT_TEAL = "Light teal";
    public final static String AMOLED_DARK = "AMOLED dark";

    public final static int LIGHT_BLUE = 0;
    public final static int BLUE = 1;
    public final static int INDIGO = 2;
    public final static int ORANGE = 3;

    public final static int YELLOW = 4;
    public final static int AMBER = 5;
    public final static int GREY = 6;
    public final static int BROWN = 7;

    public final static int CYAN = 8;
    public final static int TEAL = 9;
    public final static int LIME = 10;
    public final static int GREEN = 11;

    public final static int PINK = 12;
    public final static int RED = 13;
    public final static int PURPLE = 14;
    public final static int DEEP_PURPLE = 15;

    public final static String FIRST_USE = "firstUse";

    public final static String THEME = "appTheme";
    public final static String ACCENT_COLOR = "accentColor";
    public final static String START_PAGE = "startPage";
    public final static String CACHE_FIRST_ENABLE = "cacheFirstEnable";
    public final static String SYSTEM_DOWNLOADER = "systemDownloader";
    public final static String LANGUAGE = "language";
    public final static String LOGOUT = "logout";
    public final static String CODE_WRAP = "codeWrap";
    public final static String CUSTOM_TABS_ENABLE = "customTabsEnable";


    public final static String POP_TIMES = "popTimes";
    public final static String POP_VERSION_TIME = "popVersionTime";
    public final static String LAST_POP_TIME = "lastPopTime";

    public final static String NEW_YEAR_WISHES_TIP_ENABLE = "newYearWishesTipEnable";
    public final static String STAR_WISHES_TIP_TIMES = "starWishesTipFlag";
    public final static String LAST_STAR_WISHES_TIP_TIME = "lastStarWishesTipTime";

    public final static String DOUBLE_CLICK_TITLE_TIP_ABLE = "doubleClickTitleTipAble";
    public final static String ACTIVITY_LONG_CLICK_TIP_ABLE = "activityLongClickTipAble";
    public final static String RELEASES_LONG_CLICK_TIP_ABLE = "releasesLongClickTipAble";
    public final static String LANGUAGES_EDITOR_TIP_ABLE = "languagesEditorTipAble";
    public final static String COLLECTIONS_TIP_ABLE = "collectionsTipAble";
    public final static String BOOKMARKS_TIP_ABLE = "bookmarksTipAble";
    public final static String CUSTOM_TABS_TIPS_ENABLE = "customTabsTipsEnable";
    public final static String TOPICS_TIP_ABLE = "topicsTipAble";
    public final static String DISABLE_LOADING_IMAGE = "disableLoadingImage";


    public final static String SEARCH_RECORDS = "searchRecords";

    public static SharedPreferences getDefaultSp(){
        return PreferenceManager.getDefaultSharedPreferences(AppApplication.get());
    }

    public static void set(@NonNull String key, @NonNull Object value) {
        if (StringUtils.isBlank(key) || value == null) {
            throw new NullPointerException(String.format("Key and value not be null key=%s, value=%s", key, value));
        }
        SharedPreferences.Editor edit = getDefaultSp().edit();
        if (value instanceof String) {
            edit.putString(key, (String) value);
        } else if (value instanceof Integer) {
            edit.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            edit.putLong(key, (Long) value);
        } else if (value instanceof Boolean) {
            edit.putBoolean(key, (Boolean) value);
        } else if (value instanceof Float) {
            edit.putFloat(key, (Float) value);
        } else if(value instanceof Set){
            edit.putStringSet(key, (Set<String>) value);
        } else {
            throw new IllegalArgumentException(String.format("Type of value unsupported key=%s, value=%s", key, value));
        }
        edit.apply();
    }

    public static String getTheme(){
        return getDefaultSp(AppApplication.get()).getString(THEME, LIGHT_TEAL);
    }

    public static String getLanguage(){
        return getDefaultSp(AppApplication.get()).getString(LANGUAGE, "en");
    }

    public static SharedPreferences getDefaultSp(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferences getSP(Context context, String spName){
        return context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

}
