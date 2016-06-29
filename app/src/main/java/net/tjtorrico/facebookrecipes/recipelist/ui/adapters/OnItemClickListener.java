package net.tjtorrico.facebookrecipes.recipelist.ui.adapters;

import net.tjtorrico.facebookrecipes.entities.Recipe;

/**
 * Created by TJT on 29/06/2016.
 */
public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onItemClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
}
