package com.example.themovieapp.models.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;
    private List<Movie> results;


    public MoviesResponse(int page, List<Movie> results, int total_results, int total_pages) {
        this.page = page;
        this.results = results;
        this.totalResults = total_results;
        this.totalPages = total_pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public int getTotal_results() {
        return totalResults;
    }

    public void setTotal_results(int total_results) {
        this.totalResults = total_results;
    }

    public int getTotal_pages() {
        return totalPages;
    }

    public void setTotal_pages(int total_pages) {
        this.totalPages = total_pages;
    }
}
