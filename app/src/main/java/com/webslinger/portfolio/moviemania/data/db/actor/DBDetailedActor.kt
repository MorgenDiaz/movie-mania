package com.webslinger.portfolio.moviemania.data.db.actor

import androidx.room.Embedded
import androidx.room.Relation

data class DBDetailedActor (
    @Embedded val actor: DBActor,
    @Relation(
        parentColumn = "id",
        entityColumn = "actor_id"
    )
    val knownFor: List<DBKnownFor>,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )

    val details: DBActorDetails
)