package com.peter.android.yisgitclient;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.peter.android.yisgitclient.util.AppConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        test();
    }

    private void test() {
//        Util.getINSTANCE().getRetrofitService().fetchData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        Log.d("122334", s);
//                    }
//                });
        String randomState = UUID.randomUUID().toString();
        String url = AppConfig.OAUTH2_URL  +
                "?client_id=" + AppConfig.GITHUB_CLIENT_ID +
                "&scope=" + AppConfig.OAUTH2_SCOPE +
                "&state=" + randomState;
        openInBrowser(this,url);

    }

    public static void openInBrowser(@NonNull Context context, @NonNull String url){
        Log.d("122334", "url " + "browser start " + url);
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri).addCategory(Intent.CATEGORY_BROWSABLE);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent = createActivityChooserIntent(context, intent, uri, VIEW_IGNORE_PACKAGE);
        if(intent != null){
            context.startActivity(intent);
        } else {
//            //Toasty.warning(context, context.getString(R.string.no_browser_clients),
//                    Toast.LENGTH_LONG).show();
        }
    }

    private static final List<String> VIEW_IGNORE_PACKAGE = Arrays.asList(
            "com.gh4a", "com.fastaccess", "com.taobao.taobao"
    );

    private static Intent createActivityChooserIntent(Context context, Intent intent,
                                                      Uri uri, List<String> ignorPackageList) {
        Log.d("122334", "url " + "browser chooser");
        final PackageManager pm = context.getPackageManager();

        final List<ResolveInfo> activities = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        final ArrayList<Intent> chooserIntents = new ArrayList<>();
        final String ourPackageName = context.getPackageName();

        Collections.sort(activities, new ResolveInfo.DisplayNameComparator(pm));
        Log.d("122334", "url " + "browser activities " + activities.size());
        for (ResolveInfo resInfo : activities) {
            ActivityInfo info = resInfo.activityInfo;
            if (!info.enabled || !info.exported) {
                continue;
            }
            if (info.packageName.equals(ourPackageName)) {
                continue;
            }
            if (ignorPackageList != null && ignorPackageList.contains(info.packageName)) {
                continue;
            }
            Log.d("122334",
                    "url " + "browser loop activities " + activities.get(0).activityInfo.name);
            Intent targetIntent = new Intent(intent);
            targetIntent.setPackage(info.packageName);
            targetIntent.setDataAndType(uri, intent.getType());
            chooserIntents.add(targetIntent);
        }

        if (chooserIntents.isEmpty()) {
            return null;
        }

        final Intent lastIntent = chooserIntents.remove(chooserIntents.size() - 1);
        if (chooserIntents.isEmpty()) {
            // there was only one, no need to showImage the chooser
            return lastIntent;
        }

        Intent chooserIntent = Intent.createChooser(lastIntent, null);
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                chooserIntents.toArray(new Intent[chooserIntents.size()]));
        return chooserIntent;
    }
}
