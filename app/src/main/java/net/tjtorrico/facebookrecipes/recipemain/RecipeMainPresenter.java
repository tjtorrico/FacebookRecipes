package net.tjtorrico.facebookrecipes.recipemain;

import net.tjtorrico.facebookrecipes.entities.Recipe;
import net.tjtorrico.facebookrecipes.recipemain.events.RecipeMainEvent;
import net.tjtorrico.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by TJT on 28/06/2016.
 */
public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    RecipeMainView getView();
}
