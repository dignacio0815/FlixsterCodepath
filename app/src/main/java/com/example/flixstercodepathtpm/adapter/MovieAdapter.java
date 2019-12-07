package com.example.flixstercodepathtpm.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.flixstercodepathtpm.MovieDetailsActivity;
import com.example.flixstercodepathtpm.R;
import com.example.flixstercodepathtpm.models.Movie;

import org.parceler.Parcels;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> implements View.OnClickListener{
    private static final String TAG = "MovieAdapter";
    ImageView ivPoster;
    TextView tvOverview;
    TextView tvTitle;
    Context context;
    List<Movie> movies;
    RelativeLayout rlContainer;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // inflates a view layout and returns it as a viewholder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    // populating data into view through viewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder " + position);
        // get the movie at a position
        Movie movie = movies.get(position);
        // bind the movie data
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    // created to allow clickable events on viewHolder
    @Override
    public void onClick(View v) {
        v.setOnClickListener(this);
        try {
        } catch(Exception e) {

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            rlContainer = itemView.findViewById(R.id.rlContainer);
        }
        public void bind(final Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            Log.i(TAG, movie.getPosterPath());
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
            rlContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, movie.getTitle(), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(context, MovieDetailsActivity.class) ;
                     i.putExtra("movie", Parcels.wrap(movie));
                    context.startActivity(i);
                }
            });
        }
    }
}
