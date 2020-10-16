package com.webslinger.portfolio.moviemania.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.webslinger.portfolio.moviemania.application.di.Injector

abstract class BaseFragment: Fragment(){
    val injector: Injector by lazy {
        requireActivity().application as Injector
    }
}