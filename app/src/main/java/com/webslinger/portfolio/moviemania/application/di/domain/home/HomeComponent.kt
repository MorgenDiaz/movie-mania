package com.webslinger.portfolio.moviemania.application.di.domain.home

import com.webslinger.portfolio.moviemania.presentation.home.HomeFragment
import dagger.Subcomponent

@HomeScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): HomeComponent
    }
}