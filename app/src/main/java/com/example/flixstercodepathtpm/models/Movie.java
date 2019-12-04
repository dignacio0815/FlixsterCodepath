package com.example.flixstercodepathtpm.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    public final static String POSTER_PATH = "poster_path";
    public final static String TITLE = "original_title";
    public final static String OVERVIEW = "overview";
    // class meant to parse out the actual movies from the jsonObject being retrieved
    // takes in JSON array retrieved from MainActivity and turn it into a list of movies
    String posterPath;
    String title;
    String overview;

    public Movie(JSONObject jsonObject) throws JSONException {
         posterPath = jsonObject.getString(POSTER_PATH);
         title = jsonObject.getString(TITLE);
         overview = jsonObject.getString(OVERVIEW);
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        // iterates through JSON array and constructing a movie for each element within array
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w185/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
