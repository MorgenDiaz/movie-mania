package com.webslinger.portfolio.moviemania.data.db.character

import androidx.room.Embedded
import androidx.room.Relation
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.KnownForSchema

data class DBCharacterKnownFor (
    @Embedded val character: DBCharacter,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_id"
    )
    val knownFor: List<DBKnownFor>
): DataBaseModel