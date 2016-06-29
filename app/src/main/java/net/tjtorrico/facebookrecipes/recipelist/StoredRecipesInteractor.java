package net.tjtorrico.facebookrecipes.recipelist;

import net.tjtorrico.facebookrecipes.entities.Recipe;

/**
 * Created by TJT on 29/06/2016.
 */
public interface StoredRecipesInteractor {
    void executeUpdate(Recipe recipe);
    void executeDelete(Recipe recipe);
}
