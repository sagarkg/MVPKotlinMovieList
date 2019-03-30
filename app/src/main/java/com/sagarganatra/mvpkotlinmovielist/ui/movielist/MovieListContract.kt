package com.sagarganatra.mvpkotlinmovielist.ui.movielist

import com.sagarganatra.mvpkotlinmovielist.core.ViewState
import com.sagarganatra.mvpkotlinmovielist.data.model.Movie
import com.sagarganatra.mvpkotlinmovielist.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.Call

interface MovieListContract {
    interface View {
        fun loadMovies(data: List<Movie>)
        fun showLoading()
        fun hideLoading()
        fun showError(message: String?)
        fun showMovieDetail(id: Int)
    }

    interface Presenter {
        fun getMovies()
        fun showMovieDetails(id: Int)
    }

    interface MovieRepository {
        fun getMovies(): Single<MovieResponse>
    }
}