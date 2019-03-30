package com.sagarganatra.mvpkotlinmovielist.api

import com.sagarganatra.mvpkotlinmovielist.data.model.Movie
import com.sagarganatra.mvpkotlinmovielist.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Single<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") id:Int, @Query("api_key") apiKey: String): Single<Movie>
}