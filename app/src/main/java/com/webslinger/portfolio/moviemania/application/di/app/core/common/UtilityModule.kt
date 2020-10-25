package com.webslinger.portfolio.moviemania.application.di.app.core.common

import com.webslinger.portfolio.moviemania.application.viewmodel.TmdbImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilityModule {
    @Singleton
    @Provides
    fun provideTmdbImageLoader(): TmdbImageLoader{
        return TmdbImageLoader()
    }
}