package com.example.themovieapp.presenters;

import com.example.themovieapp.models.entities.Movie;
import com.example.themovieapp.models.repositories.MovieRepositories;

import java.util.List;

public class MoviePresenter {
    private MovieRepositories movieRepositories = new MovieRepositories();

    public void getMovie(String category, String apiKey, String language, int page, getMovieCallBack getMovieCallBack) {
        movieRepositories.requestApi(category, apiKey, language, page, new MovieRepositories.RequestApiCallBack() {
            @Override
            public void onSuccess(List<Movie> movieList) {
                getMovieCallBack.onSuccess(movieList);
            }

            @Override
            public void onFail(Throwable throwable) {
                getMovieCallBack.onFail(throwable);
            }
        });
    }

    public interface getMovieCallBack {
        void onSuccess(List<Movie> movieList);

        void onFail(Throwable t);
    }
}
