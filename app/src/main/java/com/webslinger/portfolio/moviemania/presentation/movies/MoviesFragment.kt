package com.webslinger.portfolio.moviemania.presentation.movies

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.movies.MovieViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.movies.MoviesViewModel
import com.webslinger.portfolio.moviemania.databinding.MoviesFragmentBinding
import com.webslinger.portfolio.moviemania.domain.Movie
import com.webslinger.portfolio.moviemania.presentation.BaseFragment
import javax.inject.Inject

class MoviesFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory
    private lateinit var viewModel: MoviesViewModel
    private lateinit var dataBinding: MoviesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.movies_fragment, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        injector.createMovieComponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MoviesViewModel::class.java)

        dataBinding.moviesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val moviesViewAdapter = MoviesViewAdapter()

        dataBinding.moviesProgressBar.visibility = View.VISIBLE

        viewModel.updateMovies().observe(requireActivity(), Observer {
            dataBinding.moviesProgressBar.visibility = View.GONE
            moviesViewAdapter.bindMovies(it)
        })

        dataBinding.moviesRecyclerView.adapter = moviesViewAdapter

        viewModel.updateMovies()
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }

}