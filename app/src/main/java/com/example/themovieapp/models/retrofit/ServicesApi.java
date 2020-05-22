package com.example.themovieapp.models.retrofit;

import com.example.themovieapp.models.entities.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicesApi {
    @GET("/3/movie/{category}")
    Call<MoviesResponse> getMovie(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}
