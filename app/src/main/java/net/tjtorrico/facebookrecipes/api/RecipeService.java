package net.tjtorrico.facebookrecipes.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by TJT on 27/06/2016.
 */
public interface RecipeService {
    @GET("search")
    Call<RecipeSearchResponse> search (@Query("key") String key,
                                       @Query("sort") String sort,
                                       @Query("count") int count,
                                       @Query("page") int page);
}
