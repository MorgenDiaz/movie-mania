package com.webslinger.portfolio.moviemania.data.db.character

import androidx.room.Embedded
import androidx.room.Relation

data class DBCharacterKnownFor (
    @Embedded val character: DBCharacter,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val knownFor: List<DBKnownFor>
)