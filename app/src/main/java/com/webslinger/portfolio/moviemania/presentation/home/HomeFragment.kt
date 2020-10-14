package com.webslinger.portfolio.moviemania.presentation.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.common.ViewModelFactory
import com.webslinger.portfolio.moviemania.application.home.HomeViewModel
import com.webslinger.portfolio.moviemania.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: HomeViewModel
    private lateinit var dataBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelFactory = ViewModelFactory(findNavController())
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        dataBinding.viewModel = viewModel
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}