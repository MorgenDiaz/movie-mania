package com.webslinger.portfolio.moviemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.webslinger.portfolio.moviemania.data.datamapping.movie.IMovieListMapper
import com.webslinger.portfolio.moviemania.data.db.MovieManiaDB
import com.webslinger.portfolio.moviemania.data.db.character.CharacterDAO
import com.webslinger.portfolio.moviemania.data.db.movie.MovieDAO
import com.webslinger.portfolio.moviemania.data.db.tvshow.TvShowDAO
import com.webslinger.portfolio.moviemania.data.networking.TheMovieDbRetrofitServerProducer
import com.webslinger.portfolio.moviemania.data.networking.endpoints.CharacterService
import com.webslinger.portfolio.moviemania.data.networking.endpoints.MovieService
import com.webslinger.portfolio.moviemania.data.networking.endpoints.TvShowService
import com.webslinger.portfolio.moviemania.data.repository.character.CharacterRepository
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterCacheDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.datasource.CharacterRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterListMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.CharacterNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor.KnownForDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor.KnownForMapper
import com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor.KnownForNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieCahceDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.datasource.MovieRemoteDataSource
import com.webslinger.portfolio.moviemania.data.repository.movie.MovieRepository
import com.webslinger.portfolio.moviemania.data.repository.movie.datamapping.*
import com.webslinger.portfolio.moviemania.data.repository.tvshow.TvShowRepository
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowListMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datamapping.TvShowNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.webslinger.portfolio.moviemania.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.webslinger.portfolio.moviemania.domain.Character
import com.webslinger.portfolio.moviemania.domain.Movie
import com.webslinger.portfolio.moviemania.domain.TvShow
import com.webslinger.portfolio.moviemania.domain.usecase.character.UpdateCharactersUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.movie.UpdateMoviesUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.GetTvShowsUseCase
import com.webslinger.portfolio.moviemania.domain.usecase.tvshow.UpdateTvShowsUseCase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    private val tvShows: MutableLiveData<List<TvShow>> = MutableLiveData()
    private val characters: MutableLiveData<List<Character>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        BuildConfig.THE_MOVIEDB_API_KEY

        val theMovieDBServer = TheMovieDbRetrofitServerProducer.produceNew()
        val movieService = theMovieDBServer.create(MovieService::class.java)
        val tvShowsService = theMovieDBServer.create(TvShowService::class.java)
        val characterService = theMovieDBServer.create(CharacterService::class.java)

        val movieManiaDB = MovieManiaDB.getInstance(this)

        val apiKey = BuildConfig.THE_MOVIEDB_API_KEY

        val updateMoviesUseCase = createUpdateMoviesUseCase(movieService, apiKey, movieManiaDB.movieDAO)
        val updateTvShowsUseCase = createUpdateTvShowsUseCase(tvShowsService, apiKey, movieManiaDB.tvShowDAO)
        val updateCharactersUseCase = createUpdateCharactersUseCase(characterService, apiKey, movieManiaDB.characterDAO)

        showAllNetworkData(updateCharactersUseCase, updateTvShowsUseCase, updateMoviesUseCase)

    }

    private fun createUpdateMoviesUseCase(movieService: MovieService, apiKey: String, movieDAO: MovieDAO): UpdateMoviesUseCase {
        val movieRemoteDataSource = MovieRemoteDataSource(movieService, apiKey)
        val movieLocalDataSource = MovieLocalDataSource(movieDAO)
        val movieCacheDataSource = MovieCahceDataSource()

        val movieRepository = MovieRepository(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource,
            MovieListMapper(MovieMapper(MovieNetworkToDbMapper(), MovieDbToDomainMapper()))
        )

        return UpdateMoviesUseCase(movieRepository)
    }

    private fun createUpdateTvShowsUseCase(tvShowService: TvShowService, apiKey: String, tvShowDAO: TvShowDAO): UpdateTvShowsUseCase {
        val remoteDataSource = TvShowRemoteDataSource(tvShowService, apiKey)
        val localDataSource = TvShowLocalDataSource(tvShowDAO)
        val cacheDataSource = TvShowCacheDataSource()

        val tvShowListMapper = TvShowListMapper(
            TvShowMapper(
                TvShowNetworkToDbMapper(),
                TvShowDbToDomainMapper()
            )
        )
        val tvShowRepository = TvShowRepository(
            remoteDataSource,
            localDataSource,
            cacheDataSource,
            tvShowListMapper
        )

        return UpdateTvShowsUseCase(tvShowRepository)
    }

    private fun createUpdateCharactersUseCase(characterService: CharacterService, apiKey: String, characterDAO: CharacterDAO): UpdateCharactersUseCase{
        val characterRemoteDataSource = CharacterRemoteDataSource(characterService, apiKey)
        val characterLocalDataSource = CharacterLocalDataSource(characterDAO)
        val characterCacheDataSource = CharacterCacheDataSource()

        val knownForMapper = KnownForMapper(KnownForNetworkToDbMapper(), KnownForDbToDomainMapper())
        val characterListMapper = CharacterListMapper(
            CharacterMapper(
                CharacterNetworkToDbMapper(knownForMapper),
                CharacterDbToDomainMapper(knownForMapper)
            )
        )
        val characterRepository = CharacterRepository(
            characterRemoteDataSource,
            characterLocalDataSource,
            characterCacheDataSource,
            characterListMapper
        )

        return UpdateCharactersUseCase(characterRepository)


    }

     private fun showAllNetworkData(
        updateCharactersUseCase: UpdateCharactersUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ){
        lifecycleScope.launch {
            val updatedCharacters = async(Dispatchers.IO) {
                updateCharactersUseCase.execute()
            }

            characters.value = updatedCharacters.await()
            delay(5000)

            val updatedTvShows = async(Dispatchers.IO) {
                updateTvShowsUseCase.execute()
            }

            tvShows.value = updatedTvShows.await()
            delay(5000)

            val updatedMovies = async(Dispatchers.IO) {
                updateMoviesUseCase.execute()
            }

            movies.value = updatedMovies.await()

        }
    }
}