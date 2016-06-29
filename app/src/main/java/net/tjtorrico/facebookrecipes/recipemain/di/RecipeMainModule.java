package net.tjtorrico.facebookrecipes.recipemain.di;

import net.tjtorrico.facebookrecipes.libs.EventBus;
import net.tjtorrico.facebookrecipes.recipemain.GetNextRecipeInteractor;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainPresenter;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainPresenterImpl;
import net.tjtorrico.facebookrecipes.recipemain.SaveRecipeInteractor;
import net.tjtorrico.facebookrecipes.recipemain.ui.RecipeMainView;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by TJT on 28/06/2016.
 */
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides @Singleton
    RecipeMainView providesRecipeMainView(){
        return this.view;
    }

    @Provides @Singleton
    RecipeMainPresenter providesRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor saveInteractor, GetNextRecipeInteractor getNextInteractor){
        return new RecipeMainPresenterImpl(eventBus, view, saveInteractor,getNextInteractor);
    }
}
