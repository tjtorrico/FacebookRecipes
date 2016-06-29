package net.tjtorrico.facebookrecipes.recipelist;

import net.tjtorrico.facebookrecipes.entities.Recipe;

/**
 * Created by TJT on 29/06/2016.
 */
public class StoredRecipesInteractorImpl implements StoredRecipesInteractor{
    private RecipeListRepository repository;

    public StoredRecipesInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executeUpdate(Recipe recipe) {
        repository.updateRecipe(recipe);
    }

    @Override
    public void executeDelete(Recipe recipe) {
        repository.removeRecipe(recipe);
    }
}
