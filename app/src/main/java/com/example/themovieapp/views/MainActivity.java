package com.example.themovieapp.views;


import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovieapp.R;
import com.example.themovieapp.databinding.ActivityMainBinding;
import com.example.themovieapp.models.base.BaseActivity;
import com.example.themovieapp.models.entities.Movie;
import com.example.themovieapp.models.entities.MoviesResponse;
import com.example.themovieapp.models.retrofit.Client;
import com.example.themovieapp.models.retrofit.ServicesApi;
import com.example.themovieapp.views.Adapter.MovieAdapter;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.themovieapp.BuildConfig.THE_MOVIE_DB_API_TOKEN;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private ArrayList<Movie> movies = new ArrayList<>();
    private static int PAGE = 1;
    public static String LANGUAGE = "en-US";
    private static String CATEGORY = "popular";
    private static String TOP_RATED = "top_rated";
    private static String API_KEY = "f464e68c8bda493269dc3dc20380ea29";

    @Override
    protected void init() {
        loadPopular();
        loadTopRated();

    }

    private void loadTopRated() {
        ServicesApi apiService = Client.getClient().create(ServicesApi.class);
        Call<MoviesResponse> call = apiService.getMovie(TOP_RATED, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        MovieAdapter firstAdapter = new MovieAdapter(movies);
                        RecyclerView firstRecyclerView = findViewById(R.id.rcv_top_rate);
                        LinearLayoutManager firstManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                        firstRecyclerView.setLayoutManager(firstManager);
                        firstRecyclerView.setAdapter(firstAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getApplicationContext(), "Error fetching trailer data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void loadPopular() {
        ServicesApi apiService = Client.getClient().create(ServicesApi.class);
        Call<MoviesResponse> call = apiService.getMovie(CATEGORY, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        MovieAdapter firstAdapter = new MovieAdapter(movies);
                        RecyclerView firstRecyclerView = findViewById(R.id.rcv_popular);
                        LinearLayoutManager firstManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                        firstRecyclerView.setLayoutManager(firstManager);
                        firstRecyclerView.setAdapter(firstAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(getApplicationContext(), "Error fetching trailer data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected int setContentVewId() {
        return R.layout.activity_main;
    }

}
