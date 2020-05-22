package com.example.themovieapp.views.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovieapp.databinding.MovieCardBinding;
import com.example.themovieapp.models.entities.Movie;
import com.example.themovieapp.views.Adapter.ViewHolder.MovieViewHolder;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieCardBinding view = MovieCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.binding(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
