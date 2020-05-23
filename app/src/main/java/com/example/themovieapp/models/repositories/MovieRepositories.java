package com.example.themovieapp.models.repositories;

import com.example.themovieapp.models.entities.Movie;
import com.example.themovieapp.models.entities.MoviesResponse;
import com.example.themovieapp.models.retrofit.RetrofitClient;
import com.example.themovieapp.models.retrofit.ServicesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepositories {


    public void requestApi(String category, String apiKey, String language, int page, RequestApiCallBack apiCallBack) {
        ServicesApi servicesApi = RetrofitClient.getClient().create(ServicesApi.class);
        Call<MoviesResponse> call = servicesApi.getMovie(category, apiKey, language, page);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                apiCallBack.onSuccess(movies);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                apiCallBack.onFail(t);
            }
        });
    }

    public interface RequestApiCallBack {
        void onSuccess(List<Movie> movieList);

        void onFail(Throwable throwable);
    }
}

