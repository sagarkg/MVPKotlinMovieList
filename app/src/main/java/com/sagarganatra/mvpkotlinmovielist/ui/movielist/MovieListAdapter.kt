package com.sagarganatra.mvpkotlinmovielist.ui.movielist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sagarganatra.mvpkotlinmovielist.R
import com.sagarganatra.mvpkotlinmovielist.data.model.Movie
import kotlinx.android.synthetic.main.row_movie_list.view.*

class MovieListAdapter(
    private val context: Context,
    private val movies: List<Movie>
    ): RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.row_movie_list, p0, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(p0: MovieViewHolder, p1: Int) {
        p0.bindItems(movies[p1])
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(movie: Movie) {
            itemView.title.text = movie.title
            itemView.subtitle.text = movie.releaseDate
            itemView.description.text = movie.overview
            itemView.rating.text = movie.voterAverage.toString()
        }
    }
}
