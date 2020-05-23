package com.example.themovieapp.views.Adapter.movies;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themovieapp.databinding.ItemMovieCollectionBinding;
import com.example.themovieapp.models.entities.Movie;
import com.example.themovieapp.views.Adapter.collections.MovieCollectionAdapter;

import java.util.List;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ItemMovieCollectionBinding binding;
    private MovieCollectionAdapter adapter;

    public MovieViewHolder(@NonNull ItemMovieCollectionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        initRV();
    }

    public void binding(String collectionTitle, List<Movie> movies) {
        binding.tvCollectionName.setText(collectionTitle);
        adapter.updateAdapter(movies);
    }

    private void initRV() {
        adapter = new MovieCollectionAdapter();
        binding.rvMovie.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvMovie.setAdapter(adapter);
    }
}
