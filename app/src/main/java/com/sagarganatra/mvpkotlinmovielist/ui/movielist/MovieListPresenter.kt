package com.sagarganatra.mvpkotlinmovielist.ui.movielist

import com.sagarganatra.mvpkotlinmovielist.base.IBasePresenter
import com.sagarganatra.mvpkotlinmovielist.data.repository.MovieListRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MovieListPresenter constructor(
    private val view: MovieListContract.View
) : MovieListContract.Presenter, IBasePresenter<MovieListActivity> {

    private lateinit var repository: MovieListContract.MovieRepository
    private val compositeDisposable = CompositeDisposable()

    override fun onAttach() {
        repository = MovieListRepositoryImpl()
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    override fun setView(view: MovieListActivity) {

    }


    override fun getMovies() {

        view.showLoading()

         repository.getMovies()
            .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .doOnSuccess {
                 view.hideLoading()
                 view.loadMovies(it.results)
             }.doOnError {
                 view.hideLoading()
                 view.showError(it.message)
             }.subscribe()

    }

    override fun showMovieDetails(id: Int) {
    }

}