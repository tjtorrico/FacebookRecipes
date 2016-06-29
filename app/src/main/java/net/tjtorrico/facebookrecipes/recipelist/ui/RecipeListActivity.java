package net.tjtorrico.facebookrecipes.recipelist.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.tjtorrico.facebookrecipes.FacebookRecipeApp;
import net.tjtorrico.facebookrecipes.R;
import net.tjtorrico.facebookrecipes.entities.Recipe;
import net.tjtorrico.facebookrecipes.libs.GlideImageLoader;
import net.tjtorrico.facebookrecipes.libs.ImageLoader;
import net.tjtorrico.facebookrecipes.recipelist.RecipeListPresenter;
import net.tjtorrico.facebookrecipes.recipelist.di.RecipeListComponent;
import net.tjtorrico.facebookrecipes.recipelist.ui.adapters.OnItemClickListener;
import net.tjtorrico.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;
import net.tjtorrico.facebookrecipes.recipemain.ui.RecipeMainActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipeListActivity extends AppCompatActivity implements RecipeListView, OnItemClickListener{

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private RecipesAdapter adapter;
    private RecipeListPresenter presenter;
    private RecipeListComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        ButterKnife.bind(this);

        setupToolbar();
        setupInjection();
        setupRecyclerView();

        presenter.onCreate();
        presenter.getRecipes();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recipes_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_main:
                navigateToMainScreen();
                break;
            case R.id.action_logout:
                logout();
                break;
            case R.id.action_show_all:
                presenter.showAll();
                break;
            case R.id.action_show_fav:
                presenter.showFav();
                break;
        }
        /*
        if (id == R.id.action_main) {
            navigateToMainScreen();
        }
        if (id == R.id.action_logout) {
            logout();
        }
        */
        return super.onOptionsItemSelected(item);
    }

    private void navigateToMainScreen() {
        startActivity(new Intent(this, RecipeMainActivity.class));
    }

    private void logout() {
        FacebookRecipeApp app = (FacebookRecipeApp) getApplication();
        app.logout();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.toolbar)
    public void onToolbarClick(){
        recyclerView.smoothScrollToPosition(0);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void setupInjection() {
        FacebookRecipeApp app = (FacebookRecipeApp) getApplication();
        component = app.getRecipeListComponent(this, this, this);
        presenter = getPresenter();
        adapter = getAdapter();
    }

    @Override
    public void setRecipes(List<Recipe> data) {
        adapter.setRecipes(data);
    }

    @Override
    public void recipeUpdated() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void recipeDeleted(Recipe recipe) {
        adapter.removeRecipes(recipe);
    }

    @Override
    public void onFavClick(Recipe recipe) {
        presenter.toggleFavorite(recipe);
    }

    @Override
    public void onItemClick(Recipe recipe) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getSourceURL()));
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(Recipe recipe) {
        presenter.removeRecipe(recipe);
    }

    public RecipesAdapter getAdapter() {
        return component.getAdapter();
    }

    public RecipeListPresenter getPresenter() {
        return component.getPresenter();
    }
}
