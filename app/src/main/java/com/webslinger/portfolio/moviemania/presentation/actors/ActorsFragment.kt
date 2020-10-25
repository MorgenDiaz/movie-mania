package com.webslinger.portfolio.moviemania.presentation.actors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.actors.ActorViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.actors.ActorsViewModel
import com.webslinger.portfolio.moviemania.databinding.ActorsFragmentBinding
import com.webslinger.portfolio.moviemania.presentation.BaseFragment
import javax.inject.Inject

class ActorsFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ActorViewModelFactory
    private lateinit var viewModel: ActorsViewModel
    private lateinit var binding: ActorsFragmentBinding
    private val actorsViewAdapter by lazy {
        ActorsViewAdapter(viewModel.tmdbImageLoader)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.actors_fragment,
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injector.createActorComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ActorsViewModel::class.java)

        binding.actorsRecyclerView.apply {
            adapter = actorsViewAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        showProgressBar()
        viewModel.getActors().observe(requireActivity(), Observer { actors ->
            actorsViewAdapter.bindActors(actors)
        })
    }

    private fun showProgressBar(){
        binding.actorsProgressBar.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance() = ActorsFragment()
    }
}