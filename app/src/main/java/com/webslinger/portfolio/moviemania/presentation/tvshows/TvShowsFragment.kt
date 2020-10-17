package com.webslinger.portfolio.moviemania.presentation.tvshows

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.tvshows.TvShowViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.tvshows.TvShowsViewModel
import com.webslinger.portfolio.moviemania.presentation.BaseFragment
import javax.inject.Inject

class TvShowsFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: TvShowViewModelFactory
    private lateinit var viewModel: TvShowsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tv_shows_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injector.createTvShowComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(TvShowsViewModel::class.java)
    }
    companion object {
        fun newInstance() = TvShowsFragment()
    }
}