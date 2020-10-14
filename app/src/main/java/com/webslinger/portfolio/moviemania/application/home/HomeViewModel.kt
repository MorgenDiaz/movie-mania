package com.webslinger.portfolio.moviemania.application.home

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.webslinger.portfolio.moviemania.R

class HomeViewModel(private val navController: NavController) : ViewModel() {
    fun navigateToMoviesScreen(){
        navController.navigate(R.id.action_homeFragment_to_moviesFragment)
    }

    fun navigateToTvShowsScreen(){
        navController.navigate(R.id.action_homeFragment_to_tvShowsFragment)

    }

    fun navigateToCharactersScreen(){
        navController.navigate(R.id.action_homeFragment_to_charactersFragment)
    }
}