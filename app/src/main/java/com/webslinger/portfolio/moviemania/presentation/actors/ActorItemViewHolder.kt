package com.webslinger.portfolio.moviemania.presentation.actors

import androidx.recyclerview.widget.RecyclerView
import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.databinding.TmdbItemBinding
import com.webslinger.portfolio.moviemania.domain.model.Actor

class ActorItemViewHolder(
    private val binding: TmdbItemBinding,
    private val tmdbImageLoader: TmdbImageLoader
): RecyclerView.ViewHolder(binding.root) {
    fun bindActor(actor: Actor){
        binding.titleTextView.text = actor.name

        loadActorImage(actor.profilePath)

        binding.descriptionTextView.text = actor.biography
    }

    private fun loadActorImage(imagePath:String) {
        tmdbImageLoader.loadToImageView(
            binding.root,
            imagePath,
            binding.tmdbImageView
        )
    }
}