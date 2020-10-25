package com.webslinger.portfolio.moviemania.presentation.actors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.webslinger.portfolio.moviemania.R
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.databinding.TmdbItemBinding
import com.webslinger.portfolio.moviemania.domain.model.Actor

class ActorsViewAdapter(private val tmdbImageLoader: TmdbImageLoader): RecyclerView.Adapter<ActorItemViewHolder>() {
    private var actors: List<Actor> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TmdbItemBinding>(inflater, R.layout.tmdb_item, parent, false)
        return ActorItemViewHolder(binding, tmdbImageLoader)
    }

    override fun onBindViewHolder(holder: ActorItemViewHolder, position: Int) {
        holder.bindActor(actors[position])
    }

    override fun getItemCount(): Int {
        return actors.count()
    }

    fun bindActors(actors: List<Actor>){
        this.actors = actors
        notifyDataSetChanged()
    }
}