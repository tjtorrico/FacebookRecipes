package net.tjtorrico.facebookrecipes.recipemain.di;

import net.tjtorrico.facebookrecipes.libs.ImageLoader;
import net.tjtorrico.facebookrecipes.libs.di.LibsModule;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 28/06/2016.
 */
@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
    //void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();
}
