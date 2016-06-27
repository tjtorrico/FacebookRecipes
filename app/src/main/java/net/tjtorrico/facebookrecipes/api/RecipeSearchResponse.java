package net.tjtorrico.facebookrecipes.api;

import net.tjtorrico.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by TJT on 27/06/2016.
 */
public class RecipeSearchResponse {
    private int count;
    private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipe getFirstRecipe(){
        Recipe first = null;
        if(!recipes.isEmpty()){
            first = recipes.get(0);
        }
        return first;
    }
}
