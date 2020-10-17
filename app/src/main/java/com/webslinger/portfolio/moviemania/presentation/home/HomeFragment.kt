package com.webslinger.portfolio.moviemania.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.home.HomeViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.home.HomeViewModel
import com.webslinger.portfolio.moviemania.databinding.HomeFragmentBinding
import com.webslinger.portfolio.moviemania.presentation.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel
    private lateinit var dataBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        injector.createHomeComponent().inject(this)
        initializeViewModel()
        dataBinding.viewModel = viewModel
    }

    private fun initializeViewModel() {
        homeViewModelFactory.bindNavController(findNavController())
        viewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}