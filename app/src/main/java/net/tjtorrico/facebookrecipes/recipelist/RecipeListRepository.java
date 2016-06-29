package net.tjtorrico.facebookrecipes.recipelist;

import net.tjtorrico.facebookrecipes.entities.Recipe;

/**
 * Created by TJT on 29/06/2016.
 */
public interface RecipeListRepository {
    void getSavedRecipes();
    void updateRecipe(Recipe recipe);
    void removeRecipe(Recipe recipe);

    void getFavoritesRecipes();
}
