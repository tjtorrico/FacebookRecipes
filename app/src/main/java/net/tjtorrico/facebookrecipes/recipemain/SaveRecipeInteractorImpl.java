package net.tjtorrico.facebookrecipes.recipemain;

import net.tjtorrico.facebookrecipes.entities.Recipe;

/**
 * Created by TJT on 28/06/2016.
 */
public class SaveRecipeInteractorImpl implements SaveRecipeInteractor{
    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
