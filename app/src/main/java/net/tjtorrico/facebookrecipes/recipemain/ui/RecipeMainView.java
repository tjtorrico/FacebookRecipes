package net.tjtorrico.facebookrecipes.recipemain.ui;

import net.tjtorrico.facebookrecipes.entities.Recipe;

/**
 * Created by TJT on 28/06/2016.
 */
public interface RecipeMainView {
    void showProgress();
    void hideProgress();

    void showUIElements();
    void hideUIElements();

    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();

    void setRecipe(Recipe recipe);

    void onGetRecipeError(String error);

}
