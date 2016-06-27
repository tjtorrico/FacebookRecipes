package net.tjtorrico.facebookrecipes.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by TJT on 27/06/2016.
 */
@Database(name = RecipesDatabase.NAME, version = RecipesDatabase.VERSION)
public class RecipesDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "Recipes";
}
