package com.example.themovieapp.views.Adapter.collections;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovieapp.databinding.MovieCardBinding;
import com.example.themovieapp.models.entities.Movie;
import com.squareup.picasso.Picasso;

public class MovieCollectionViewHolder extends RecyclerView.ViewHolder {
    private MovieCardBinding binding;

    public MovieCollectionViewHolder(@NonNull MovieCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void binding(Movie movie) {
        binding.tvTitle.setText(movie.getOriginal_title());
        String vote = Double.toString(movie.getVote_average());
        binding.tvUserRating.setText(vote);

        String poster = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
        Picasso.get().load(movie.getMoviePath(movie.getPoster_path())).into(binding.ivThumbnail);
    }
}
