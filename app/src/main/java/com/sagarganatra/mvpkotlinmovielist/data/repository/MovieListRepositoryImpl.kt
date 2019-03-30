package com.sagarganatra.mvpkotlinmovielist.data.repository

import com.sagarganatra.mvpkotlinmovielist.api.HttpClient
import com.sagarganatra.mvpkotlinmovielist.api.MoviesApi
import com.sagarganatra.mvpkotlinmovielist.data.model.MovieResponse
import com.sagarganatra.mvpkotlinmovielist.ui.movielist.MovieListContract
import io.reactivex.Single


class MovieListRepositoryImpl() : MovieListContract.MovieRepository {
    private val moviesApi: MoviesApi = HttpClient.client.create(MoviesApi::class.java)

    override fun getMovies(): Single<MovieResponse> {
        return moviesApi.getTopRatedMovies(HttpClient.API_KEY)
    }
}
