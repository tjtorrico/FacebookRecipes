package net.tjtorrico.facebookrecipes.recipemain;

import java.util.Random;

/**
 * Created by TJT on 28/06/2016.
 */
public class GetNextRecipeInteractorImpl implements GetNextRecipeInteractor{
    RecipeMainRepository repository;

    public GetNextRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.saveRecipePage(recipePage);
        repository.getNextRecipe();
    }
}
