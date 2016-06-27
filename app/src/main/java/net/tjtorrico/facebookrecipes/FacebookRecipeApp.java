package net.tjtorrico.facebookrecipes;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by TJT on 27/06/2016.
 */
public class FacebookRecipeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }
}
