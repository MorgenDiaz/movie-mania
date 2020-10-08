package com.webslinger.portfolio.moviemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.webslinger.portfolio.moviemania.data.db.MovieManiaDB
import com.webslinger.portfolio.moviemania.data.dto.movie.MovieDTO
import com.webslinger.portfolio.moviemania.data.networking.TheMovieDbRetrofitServerProducer
import com.webslinger.portfolio.moviemania.data.networking.endpoints.MovieService
import com.webslinger.portfolio.moviemania.data.repository.MovieCahceDataSource
import com.webslinger.portfolio.moviemania.data.repository.MovieLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.MovieRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.MovieRepository
import com.webslinger.portfolio.moviemania.domain.Movie
import com.webslinger.portfolio.moviemania.domain.usecase.movie.UpdateMoviesUseCase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        BuildConfig.THE_MOVIEDB_API_KEY

        val theMovieDBServer = TheMovieDbRetrofitServerProducer.produceNew()

        val movieManiaDB = MovieManiaDB.getInstance(this)

        val apiKey = BuildConfig.THE_MOVIEDB_API_KEY
        val movieRemoteDataSource = MovieRemoteDataSource(theMovieDBServer.create(MovieService::class.java), apiKey)
        val movieLocalDataSource = MovieLocalDataSource(movieManiaDB.movieDAO)
        val movieCacheDataSource = MovieCahceDataSource()

        val movieRepository = MovieRepository(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource,
            MovieDTO()
        )

        val updateMoviesUseCase = UpdateMoviesUseCase(movieRepository)

        val movies: MutableLiveData<List<Movie>> = MutableLiveData()

        lifecycleScope.launch{

            val updatedMovies = async (Dispatchers.IO) {
                return@async updateMoviesUseCase.execute()
            }

            movies.value = updatedMovies.await()
        }

        movies.observe(this, Observer {
            main_text_view.text = ""

            var movieTitles: String = ""
            it.forEach{movie ->
                movieTitles += movie.title
                movieTitles += "\n"
            }

            main_text_view.text = movieTitles

        })
    }
}