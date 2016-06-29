package net.tjtorrico.facebookrecipes.recipelist.di;

import net.tjtorrico.facebookrecipes.libs.di.LibsModule;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListPresenter;
import net.tjtorrico.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by TJT on 28/06/2016.
 */
@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {
    RecipesAdapter getAdapter();
    RecipeListPresenter getPresenter();
}
