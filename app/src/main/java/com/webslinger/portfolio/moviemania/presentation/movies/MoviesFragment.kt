package com.webslinger.portfolio.moviemania.presentation.movies

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.movies.MovieViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.movies.MoviesViewModel
import com.webslinger.portfolio.moviemania.databinding.MoviesFragmentBinding
import com.webslinger.portfolio.moviemania.domain.model.Movie
import com.webslinger.portfolio.moviemania.presentation.BaseFragment
import javax.inject.Inject

class MoviesFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: MovieViewModelFactory
    private lateinit var viewModel: MoviesViewModel
    private lateinit var binding: MoviesFragmentBinding
    private val moviesViewAdapter by lazy {
        MoviesViewAdapter(viewModel.tmdbImageLoader)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.movies_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_update-> {
                showProgressBar()

                viewModel.updateMovies().observe(this, Observer {movies ->
                    loadMovies(moviesViewAdapter, movies)
                })
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        injector.createMovieComponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MoviesViewModel::class.java)

        initializeMoviesRecyclerView()

    }

    private fun showProgressBar() {
        binding.moviesProgressBar.visibility = View.VISIBLE
    }

    private fun initializeMoviesRecyclerView() {
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.moviesRecyclerView.adapter = moviesViewAdapter

        showProgressBar()
        viewModel.getMovies().observe(requireActivity(), Observer { movies ->
            loadMovies(moviesViewAdapter, movies)
        })
    }

    private fun loadMovies(
        moviesViewAdapter: MoviesViewAdapter,
        it: List<Movie>
    ) {
        binding.moviesProgressBar.visibility = View.GONE
        moviesViewAdapter.bindMovies(it)
        binding.moviesRecyclerView.scrollToPosition(0)
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }

}