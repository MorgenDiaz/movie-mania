package com.webslinger.portfolio.moviemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.webslinger.portfolio.moviemania.domain.model.Actor
import com.webslinger.portfolio.moviemania.domain.model.Movie
import com.webslinger.portfolio.moviemania.domain.model.TvShow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
    }

}