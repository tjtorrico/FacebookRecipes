package net.tjtorrico.facebookrecipes.recipelist;

import com.raizlabs.android.dbflow.list.FlowCursorList;

import net.tjtorrico.facebookrecipes.entities.Recipe;
import net.tjtorrico.facebookrecipes.libs.EventBus;
import net.tjtorrico.facebookrecipes.recipelist.events.RecipeListEvent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by TJT on 29/06/2016.
 */
public class RecipeListRepositoryImpl implements RecipeListRepository{
    private EventBus eventBus;

    @Override
    public void getSavedRecipes() {
        FlowCursorList<Recipe> storedRecipes = new FlowCursorList<Recipe>(false, Recipe.class);
        post(RecipeListEvent.READ_EVENT, storedRecipes.getAll());
        storedRecipes.close();
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        recipe.update();
        post();
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        recipe.delete();
        post(RecipeListEvent.DELETE_EVENT, Arrays.asList(recipe));
    }

    private void post(int type, List<Recipe> recipeList){
        RecipeListEvent event = new RecipeListEvent();
        event.setType(type);
        event.setRecipes(recipeList);
        eventBus.post(event);
    }

    private void post(){
        post(RecipeListEvent.UPDATE_EVENT, null);
    }
}
