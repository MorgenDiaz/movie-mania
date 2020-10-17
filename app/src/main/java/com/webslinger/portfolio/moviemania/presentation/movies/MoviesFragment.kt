package com.webslinger.portfolio.moviemania.presentation.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.movies.MovieViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.movies.MoviesViewModel
import com.webslinger.portfolio.moviemania.presentation.BaseFragment
import javax.inject.Inject

class MoviesFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        injector.createMovieComponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MoviesViewModel::class.java)
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }

}