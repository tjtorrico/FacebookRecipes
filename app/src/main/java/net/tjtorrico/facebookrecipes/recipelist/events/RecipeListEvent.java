package net.tjtorrico.facebookrecipes.recipelist.events;

import net.tjtorrico.facebookrecipes.entities.Recipe;

import java.util.List;

/**
 * Created by TJT on 29/06/2016.
 */
public class RecipeListEvent {
    private int type;
    private List<Recipe> recipes;
    public final static int READ_EVENT = 0;
    public final static int UPDATE_EVENT = 1;
    public final static int DELETE_EVENT = 2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
