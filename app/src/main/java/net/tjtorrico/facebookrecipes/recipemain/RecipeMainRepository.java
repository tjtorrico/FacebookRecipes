package net.tjtorrico.facebookrecipes.recipemain;

import net.tjtorrico.facebookrecipes.entities.Recipe;

/**
 * Created by TJT on 28/06/2016.
 */
public interface RecipeMainRepository {
    public final static int COUNT = 1;
    public final static String RECENT_SORT = "r";
    public final static int RECIPE_RANGE = 100000;

    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void saveRecipePage(int recipePage);
}
