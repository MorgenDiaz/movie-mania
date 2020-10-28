package com.webslinger.portfolio.moviemania.application.di.app.core.actor

import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import com.webslinger.portfolio.moviemania.application.viewmodel.actors.ActorViewModelFactory
import com.webslinger.portfolio.moviemania.application.viewmodel.actors.ActorsScreenStateController
import com.webslinger.portfolio.moviemania.domain.usecase.actor.GetActorsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.actor.UpdateActorsUseCase
import dagger.Module
import dagger.Provides

@Module
class ActorModule {
    @Provides
    fun provideActorViewModelFactory(
        getActorsUseCase: GetActorsUseCase,
        updateActorsUseCase: UpdateActorsUseCase,
        tmdbImageLoader: TmdbImageLoader
    ): ActorViewModelFactory{
        return ActorViewModelFactory(
            getActorsUseCase,
            updateActorsUseCase,
            ActorsScreenStateController(),
            tmdbImageLoader
        )
    }
}