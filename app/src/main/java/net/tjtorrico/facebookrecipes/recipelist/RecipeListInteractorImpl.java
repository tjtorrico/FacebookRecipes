package net.tjtorrico.facebookrecipes.recipelist;

/**
 * Created by TJT on 29/06/2016.
 */
public class RecipeListInteractorImpl implements RecipeListInteractor{
    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }

    @Override
    public void searchFavorites() {
        repository.getFavoritesRecipes();
    }
}
