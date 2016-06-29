package net.tjtorrico.facebookrecipes.recipemain.di;

import net.tjtorrico.facebookrecipes.api.RecipeClient;
import net.tjtorrico.facebookrecipes.api.RecipeService;
import net.tjtorrico.facebookrecipes.libs.EventBus;
import net.tjtorrico.facebookrecipes.recipemain.GetNextRecipeInteractor;
import net.tjtorrico.facebookrecipes.recipemain.GetNextRecipeInteractorImpl;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainPresenter;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainPresenterImpl;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainRepository;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainRepositoryImpl;
import net.tjtorrico.facebookrecipes.recipemain.SaveRecipeInteractor;
import net.tjtorrico.facebookrecipes.recipemain.SaveRecipeInteractorImpl;
import net.tjtorrico.facebookrecipes.recipemain.ui.RecipeMainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 28/06/2016.
 */
@Module
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

    @Provides @Singleton
    SaveRecipeInteractor providesSaveRecipeInteractor(RecipeMainRepository repository){
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor providesGetNextRecipeInteractor(RecipeMainRepository repository){
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeMainRepository providesRecipeMainRepository(EventBus eventBus, RecipeService service){
        return new RecipeMainRepositoryImpl(eventBus, service);
    }

    @Provides @Singleton
    RecipeService providesRecipeService(){
        return new RecipeClient().getRecipeService();
    }
}
