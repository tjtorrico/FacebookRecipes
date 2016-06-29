package net.tjtorrico.facebookrecipes.recipelist.di;

import net.tjtorrico.facebookrecipes.api.RecipeClient;
import net.tjtorrico.facebookrecipes.api.RecipeService;
import net.tjtorrico.facebookrecipes.entities.Recipe;
import net.tjtorrico.facebookrecipes.libs.EventBus;
import net.tjtorrico.facebookrecipes.libs.ImageLoader;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListInteractor;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListInteractorImpl;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListPresenter;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListPresenterImpl;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListRepository;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListRepositoryImpl;
import net.tjtorrico.facebookrecipes.recipelist.StoredRecipesInteractor;
import net.tjtorrico.facebookrecipes.recipelist.StoredRecipesInteractorImpl;
import net.tjtorrico.facebookrecipes.recipelist.ui.RecipeListView;
import net.tjtorrico.facebookrecipes.recipelist.ui.adapters.OnItemClickListener;
import net.tjtorrico.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;
import net.tjtorrico.facebookrecipes.recipemain.GetNextRecipeInteractor;
import net.tjtorrico.facebookrecipes.recipemain.GetNextRecipeInteractorImpl;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainPresenter;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainPresenterImpl;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainRepository;
import net.tjtorrico.facebookrecipes.recipemain.RecipeMainRepositoryImpl;
import net.tjtorrico.facebookrecipes.recipemain.SaveRecipeInteractor;
import net.tjtorrico.facebookrecipes.recipemain.SaveRecipeInteractorImpl;
import net.tjtorrico.facebookrecipes.recipemain.ui.RecipeMainView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by TJT on 28/06/2016.
 */
@Module
public class RecipeListModule {
    RecipeListView view;
    OnItemClickListener clickListener;

    public RecipeListModule(RecipeListView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides @Singleton
    RecipeListView providesRecipeListView(){
        return this.view;
    }

    @Provides @Singleton
    RecipeListPresenter providesRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor){
        return new RecipeListPresenterImpl(eventBus, view, listInteractor, storedInteractor);
    }

    @Provides @Singleton
    StoredRecipesInteractor providesStoredRecipesInteractor(RecipeListRepository repository){
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListInteractor providesRecipeListInteractor(RecipeListRepository repository){
        return new RecipeListInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListRepository providesRecipeListRepository(EventBus eventBus){
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides @Singleton
    RecipesAdapter providesRecipesAdapter(List<Recipe> recipes, ImageLoader imageLoader, OnItemClickListener onItemClickListener){
        return new RecipesAdapter(recipes, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides @Singleton
    List<Recipe> providesEmpyList(){
        return new ArrayList<Recipe>();
    }
}
