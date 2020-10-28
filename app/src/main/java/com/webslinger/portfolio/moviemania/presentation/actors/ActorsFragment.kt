package com.webslinger.portfolio.moviemania.presentation.actors

import android.os.Bundle
import android.view.*
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

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_update ->{
                showProgressBar()
                viewModel.updateActors()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injector.createActorComponent().inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ActorsViewModel::class.java)

        initActorsRecyclerView()

        showProgressBar()
        viewModel.retrieveActors()
    }

    private fun initActorsRecyclerView() {
        binding.actorsRecyclerView.apply {
            adapter = actorsViewAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        bindActors()
    }

    private fun bindActors() {
        viewModel.actors.observe(requireActivity(), Observer { actors ->
            actorsViewAdapter.bindActors(actors)
            binding.actorsRecyclerView.scrollToPosition(0)
            binding.actorsProgressBar.visibility = View.GONE
        })
    }

    private fun showProgressBar(){
        binding.actorsProgressBar.visibility = View.VISIBLE
    }

    companion object {
        fun newInstance() = ActorsFragment()
    }
}