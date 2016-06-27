package net.tjtorrico.facebookrecipes.libs.di;

import android.app.Activity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import net.tjtorrico.facebookrecipes.libs.EventBus;
import net.tjtorrico.facebookrecipes.libs.GlideImageLoader;
import net.tjtorrico.facebookrecipes.libs.GreenRobotEventBus;
import net.tjtorrico.facebookrecipes.libs.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 27/06/2016.
 */
@Module
public class LibsModule {
    Activity activity;

    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Activity activity) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (activity != null) {
            imageLoader.setLoaderContext(activity);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    RequestManager providesRequestManager (Activity activity){
        return Glide.with(activity);
    }

    @Provides
    @Singleton
    Activity providesActivity(){
        return this.activity;
    }

    @Provides
    @Singleton
    EventBus provideEventBus(org.greenrobot.eventbus.EventBus eventBus) {
        return new GreenRobotEventBus(eventBus);
    }

    @Provides
    @Singleton
    org.greenrobot.eventbus.EventBus providesLibraryEventBus(){
        return org.greenrobot.eventbus.EventBus.getDefault();
    }
}
