package com.example.themovieapp.views.Adapter.collections;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovieapp.databinding.MovieCardBinding;
import com.example.themovieapp.models.entities.Movie;
import com.example.themovieapp.views.Adapter.movies.MovieViewHolder;

import java.util.List;

public class MovieCollectionAdapter extends RecyclerView.Adapter<MovieCollectionViewHolder> {
    private List<Movie> movieList;

    public MovieCollectionAdapter() {
        notifyDataSetChanged();
    }

    public void updateAdapter(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieCardBinding view = MovieCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieCollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCollectionViewHolder holder, int position) {
        holder.binding(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }
}
