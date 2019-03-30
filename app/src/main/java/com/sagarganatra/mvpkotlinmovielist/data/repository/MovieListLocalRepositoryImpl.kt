package com.sagarganatra.mvpkotlinmovielist.data.repository

import android.content.Context
import com.google.gson.Gson
import com.sagarganatra.mvpkotlinmovielist.data.model.MovieResponse
import com.sagarganatra.mvpkotlinmovielist.ui.movielist.MovieListContract
import io.reactivex.Single

class MovieListLocalRepositoryImpl(
    private val context: Context
): MovieListContract.MovieRepository {

    companion object {
        private val TAG = this::class.java.simpleName
    }


    override fun getMovies(): Single<MovieResponse> {

        return Single.fromCallable {
            getLocalMoviesData(context)
        }
    }

}

fun getLocalMoviesData(context: Context): MovieResponse? {

    return try {
        val filePath = context.assets
        val ioStream  = filePath.open("data/movies.json")
        val inputString = ioStream.bufferedReader().use { it.readText() }
        Gson().fromJson(inputString, MovieResponse::class.java)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}