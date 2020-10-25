package com.webslinger.portfolio.moviemania.presentation.tvshows

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.tvshows.TvShowViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.tvshows.TvShowsViewModel
import com.webslinger.portfolio.moviemania.databinding.TvShowsFragmentBinding
import com.webslinger.portfolio.moviemania.domain.model.TvShow
import com.webslinger.portfolio.moviemania.presentation.BaseFragment
import javax.inject.Inject

class TvShowsFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: TvShowViewModelFactory
    private lateinit var viewModel: TvShowsViewModel
    private lateinit var binding: TvShowsFragmentBinding
    private val tvShowsAdapter by lazy {
        TvShowsViewAdapter(viewModel.tmdbImageLoader)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.tv_shows_fragment,
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
            R.id.action_update -> {
                showProgressBar()
                viewModel.updateTvShows().observe(this, Observer { tvShows ->
                    loadTvShows(tvShows)
                })
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injector.createTvShowComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(TvShowsViewModel::class.java)

        initializeTvShowRecycler()
    }

    private fun initializeTvShowRecycler() {
        showProgressBar()
        binding.tvShowsRecyclerView.adapter = tvShowsAdapter
        binding.tvShowsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getTvShows().observe(requireActivity(), Observer { tvShows ->
            loadTvShows(tvShows)
        })
    }

    private fun showProgressBar() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
    }

    private fun loadTvShows(tvShows: List<TvShow>) {
        binding.tvShowProgressBar.visibility = View.GONE
        tvShowsAdapter.bindTvShows(tvShows)
        binding.tvShowsRecyclerView.scrollToPosition(0)
    }

    companion object {
        fun newInstance() = TvShowsFragment()
    }
}