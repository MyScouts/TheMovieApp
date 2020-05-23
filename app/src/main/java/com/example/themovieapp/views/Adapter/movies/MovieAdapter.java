package com.example.themovieapp.views.Adapter.movies;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovieapp.databinding.ItemMovieCollectionBinding;
import com.example.themovieapp.models.entities.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private int ADAPTER_SIZE = 3;

    private List<Movie> moviePopularList;
    private List<Movie> movieTopRateList;
    private List<Movie> movieInCommingList;

    public MovieAdapter() {
    }

    public void updateAdapter(List<Movie> moviePopularList, List<Movie> movieTopRateList, List<Movie> movieInCommingList) {
        this.moviePopularList = moviePopularList;
        this.movieTopRateList = movieTopRateList;
        this.movieInCommingList = movieInCommingList;
        notifyDataSetChanged();
    }

    public void updatePopular(List<Movie> moviePopularList) {
        this.moviePopularList = moviePopularList;
        notifyItemChanged(0);
    }

    public void updateTopRate(List<Movie> movieTopRateList) {
        this.movieTopRateList = movieTopRateList;
        notifyItemChanged(1);
    }

    public void updateIncomming(List<Movie> movieInCommingList) {
        this.movieInCommingList = movieInCommingList;
        notifyItemChanged(2);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieCollectionBinding view = ItemMovieCollectionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.binding("POPULAR", moviePopularList);
                break;
            case 1:
                holder.binding("TOP RATED", movieTopRateList);
                break;
            default:
                holder.binding("INCOMMING", movieInCommingList);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return ADAPTER_SIZE;
    }
}
