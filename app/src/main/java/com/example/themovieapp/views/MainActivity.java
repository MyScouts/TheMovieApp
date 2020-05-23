package com.example.themovieapp.views;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.themovieapp.R;
import com.example.themovieapp.databinding.ActivityMainBinding;
import com.example.themovieapp.models.base.BaseActivity;
import com.example.themovieapp.models.entities.Movie;
import com.example.themovieapp.presenters.MoviePresenter;
import com.example.themovieapp.views.Adapter.movies.MovieAdapter;

import java.util.List;


public class MainActivity extends BaseActivity<ActivityMainBinding> implements MoviePresenter.getMovieCallBack {
    private MoviePresenter moviePresenter = new MoviePresenter();
    private MoviePresenter movieTopRate = new MoviePresenter();
    private MovieAdapter firstAdapter = new MovieAdapter();


    private static int PAGE = 1;
    public static String LANGUAGE = "en-US";
    private static String CATEGORY = "popular";
    private static String TOP_RATED = "top_rated";
    private static String API_KEY = "f464e68c8bda493269dc3dc20380ea29";

    @Override
    protected void init() {
        initRV();

        showLoading();
        moviePresenter.getMovie(CATEGORY, API_KEY, LANGUAGE, PAGE, this);

        loadPopular();
    }

    private void loadPopular() {

    }

    @Override
    protected int setContentVewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(List<Movie> movieList) {
        hideLoading();
//        firstAdapter.updateAdapter(movieList, movieList, movieList);

        firstAdapter.updatePopular(movieList);
        firstAdapter.updateTopRate(movieList);
        firstAdapter.updateIncomming(movieList);

    }

    private void initRV() {
        LinearLayoutManager firstManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        getBinding().rvMovieParent.setLayoutManager(firstManager);
        getBinding().rvMovieParent.setAdapter(firstAdapter);
    }

    @Override
    public void onFail(Throwable t) {
        showToast(t.getMessage());
    }
}
