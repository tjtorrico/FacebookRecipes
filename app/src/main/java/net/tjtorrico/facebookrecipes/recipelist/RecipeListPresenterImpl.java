package net.tjtorrico.facebookrecipes.recipelist;

import net.tjtorrico.facebookrecipes.entities.Recipe;
import net.tjtorrico.facebookrecipes.libs.EventBus;
import net.tjtorrico.facebookrecipes.recipelist.events.RecipeListEvent;
import net.tjtorrico.facebookrecipes.recipelist.ui.RecipeListView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by TJT on 29/06/2016.
 */
public class RecipeListPresenterImpl implements RecipeListPresenter{
    private EventBus eventBus;
    private RecipeListView view;
    private RecipeListInteractor listInteractor;
    private StoredRecipesInteractor storedInteractor;

    public RecipeListPresenterImpl(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor) {
        this.eventBus = eventBus;
        this.view = view;
        this.listInteractor = listInteractor;
        this.storedInteractor = storedInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void getRecipes() {
        listInteractor.execute();
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        storedInteractor.executeDelete(recipe);
    }

    @Override
    public void toggleFavorite(Recipe recipe) {
        boolean fav = recipe.getFavorite();
        recipe.setFavorite(!fav);
        storedInteractor.executeUpdate(recipe);
    }

    @Override
    @Subscribe
    public void onEventMainThread(RecipeListEvent event) {
        if (this.view != null) {
            switch (event.getType()){
                case RecipeListEvent.READ_EVENT:
                    view.setRecipes(event.getRecipes());
                    break;
                case RecipeListEvent.UPDATE_EVENT:
                    view.recipeUpdated();
                    break;
                case RecipeListEvent.DELETE_EVENT:
                    Recipe recipe = event.getRecipes().get(0);
                    view.recipeDeleted(recipe);
                    break;
            }
        }
    }

    @Override
    public void showAll() {
        listInteractor.execute();
    }

    @Override
    public void showFav() {
        listInteractor.searchFavorites();
    }

    @Override
    public RecipeListView getView() {
        return this.view;
    }
}
