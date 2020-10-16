package com.webslinger.portfolio.moviemania.application.di.domain.home

import com.webslinger.portfolio.moviemania.application.viewmodel.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    fun provideHomeViewModelFactory():HomeViewModelFactory{
        return HomeViewModelFactory()
    }
}