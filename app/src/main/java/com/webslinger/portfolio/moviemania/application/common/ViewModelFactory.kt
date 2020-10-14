package com.webslinger.portfolio.moviemania.application.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.webslinger.portfolio.moviemania.application.home.HomeViewModel


class ViewModelFactory(private val navController: NavController) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when (modelClass) {
            HomeViewModel::class.java -> {
                return HomeViewModel(navController) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class.")
            }
        }

    }
}