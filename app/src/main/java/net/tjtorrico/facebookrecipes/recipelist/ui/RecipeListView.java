package net.tjtorrico.facebookrecipes.recipelist.ui;

import net.tjtorrico.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by TJT on 29/06/2016.
 */
public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdated();
    void recipeDeleted(Recipe recipe);
}
