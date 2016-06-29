package net.tjtorrico.facebookrecipes;

import android.app.Application;
import android.content.Intent;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.raizlabs.android.dbflow.config.FlowManager;

import net.tjtorrico.facebookrecipes.libs.di.LibsModule;
import net.tjtorrico.facebookrecipes.login.ui.LoginActivity;
import net.tjtorrico.facebookrecipes.recipemain.di.DaggerRecipeMainComponent;
import net.tjtorrico.facebookrecipes.recipemain.di.RecipeMainComponent;
import net.tjtorrico.facebookrecipes.recipemain.di.RecipeMainModule;
import net.tjtorrico.facebookrecipes.recipemain.ui.RecipeMainActivity;
import net.tjtorrico.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by TJT on 27/06/2016.
 */
public class FacebookRecipeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view){
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeMainModule(new RecipeMainModule(view))
                .build();
    }
}
