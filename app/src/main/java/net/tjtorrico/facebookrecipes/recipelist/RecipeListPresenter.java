package net.tjtorrico.facebookrecipes.recipelist;

import net.tjtorrico.facebookrecipes.entities.Recipe;
import net.tjtorrico.facebookrecipes.recipelist.events.RecipeListEvent;
import net.tjtorrico.facebookrecipes.recipelist.ui.RecipeListView;

/**
 * Created by TJT on 29/06/2016.
 */
public interface RecipeListPresenter {
    void onCreate();
    void onDestroy();

    void getRecipes();
    void removeRecipe(Recipe recipe);
    void toggleFavorite(Recipe recipe);
    void onEventMainThread(RecipeListEvent event);

    RecipeListView getView();
}
