package com.webslinger.portfolio.moviemania.data.db.actor

import androidx.room.*

@Dao
abstract class ActorDAO {
    suspend fun saveActors(actorsDetailed: List<DBDetailedActor>){
        saveBaseActors(actorsDetailed.map { it.actor })

        actorsDetailed.forEach {
            saveKnownFor(it.knownFor)
            saveDetails(it.details)
        }
    }

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract suspend fun saveBaseActors(actors: List<DBActor>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveKnownFor(knownFor: List<DBKnownFor>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveDetails(actorDetails: DBActorDetails)

    suspend fun deleteAllActors(){
        deleteBaseActors()
        deleteKnownFor()
        deleteDetails()
    }

    @Query("DELETE FROM actors_table")
    abstract suspend fun deleteBaseActors()

    @Query("DELETE FROM known_for_table")
    abstract suspend fun deleteKnownFor()

    @Query("DELETE FROM actor_details_table")
    abstract suspend fun deleteDetails()

    @Transaction
    @Query("SELECT * FROM actors_table")
    abstract fun getAllActors(): List<DBDetailedActor>
}