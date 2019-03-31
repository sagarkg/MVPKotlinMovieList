package com.sagarganatra.mvpkotlinmovielist.ui.movielist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.sagarganatra.mvpkotlinmovielist.R
import com.sagarganatra.mvpkotlinmovielist.base.IBaseView
import com.sagarganatra.mvpkotlinmovielist.data.model.Movie
import kotlinx.android.synthetic.main.activity_movielist.*

class MovieListActivity : AppCompatActivity(), MovieListContract.View, IBaseView {

    private lateinit var presenter: MovieListPresenter
    private lateinit var adapter: MovieListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movielist)

        presenter = MovieListPresenter(this)
        presenter.onAttach()
        presenter.getMovies()
    }


    override fun loadMovies(data: List<Movie>) {

            linearLayoutManager = LinearLayoutManager(this)
            movieListRecyclerView.layoutManager = linearLayoutManager
            adapter = MovieListAdapter(this, data)
            movieListRecyclerView.adapter = adapter
    }

    override fun showLoading(){
        progressBar.visibility = View.VISIBLE
        errorMessageTextView.visibility = View.GONE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError(message: String?) {
        errorMessageTextView.visibility = View.VISIBLE
        errorMessageTextView.text = message
    }

    override fun showMovieDetail(id: Int) {
        // Navigate to MovieDetailActivity

    }

    override fun onStop() {
        super.onStop()
        presenter.onDetach()
    }
}
