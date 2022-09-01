

package com.peter.android.yisgitclient.util;

import android.content.Context;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FileUtil {

    private final static String AUDIO_CACHE_DIR_NAME = "audio";

    private final static String SIGN_IMAGE_CACHE_DIR_NAME = "sign_image";

    private final static String HTTP_CACHE_DIR_NAME = "http_response";

    /**
     * fetch cache directory
     *
     * @param context
     * @param dirName
     * @return cache file
     */
    public static File getCacheDir(@NonNull Context context, @NonNull String dirName) {
        File rootDir = context.getExternalCacheDir();
        File cacheFile = new File(rootDir, dirName);
        if (!cacheFile.exists()) {
            cacheFile.mkdir();
        }
        return cacheFile;
    }

    /**
     * fetch network request cache folder
     * @param context
     * @return cache file
     */
    public static File getHttpImageCacheDir(@NonNull Context context) {
        return getCacheDir(context, HTTP_CACHE_DIR_NAME);
    }
}
