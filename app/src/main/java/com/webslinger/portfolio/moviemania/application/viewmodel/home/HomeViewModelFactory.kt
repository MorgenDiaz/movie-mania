package com.webslinger.portfolio.moviemania.application.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController


class HomeViewModelFactory() : ViewModelProvider.Factory {
    private lateinit var navController: NavController

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(navController) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class.")
    }

    fun bindNavController(navController: NavController){
        this.navController = navController
    }
}