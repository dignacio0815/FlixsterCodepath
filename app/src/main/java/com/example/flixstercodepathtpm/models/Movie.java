package com.example.flixstercodepathtpm.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    public final static String POSTER_PATH = "poster_path";
    public final static String TITLE = "original_title";
    public final static String OVERVIEW = "overview";
    public final static String VOTE_AVERAGE = "vote_average";
    public final static String ID = "id";
    // class meant to parse out the actual movies from the jsonObject being retrieved
    // takes in JSON array retrieved from MainActivity and turn it into a list of movies
    String posterPath;
    String title;
    String overview;
    int movieID;
    double ratingBar;

    // no-arg, empty constructor required for Parceler
    public Movie() {}

    public Movie(JSONObject jsonObject) throws JSONException {
         posterPath = jsonObject.getString(POSTER_PATH);
         title = jsonObject.getString(TITLE);
         overview = jsonObject.getString(OVERVIEW);
         ratingBar = jsonObject.getDouble(VOTE_AVERAGE);
         movieID = jsonObject.getInt(ID);
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
        return String.format("https://image.tmdb.org/t/p/w500/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() {
        return ratingBar;
    }

    public int getMovieID() {
        return movieID;
    }
}
