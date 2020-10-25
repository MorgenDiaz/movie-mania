package com.webslinger.portfolio.moviemania.application.di.app.core.actor

import com.webslinger.portfolio.moviemania.presentation.actors.ActorsFragment
import dagger.Subcomponent

@ActorsScope
@Subcomponent(modules = [ActorModule::class])
interface ActorComponent {
    fun inject(actorsFragment: ActorsFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ActorComponent
    }
}