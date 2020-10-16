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
        injector.createHomeComponent().inject(this)

        initializeViewModel()

        initializeDataBinding(inflater, container)

        return dataBinding.root
    }

    private fun initializeViewModel() {
        homeViewModelFactory.bindNavController(findNavController())
        viewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
    }

    private fun initializeDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        dataBinding.viewModel = viewModel
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}