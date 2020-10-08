package com.webslinger.portfolio.moviemania.data.dto

import com.webslinger.portfolio.moviemania.data.db.character.DBCharacter
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.db.character.KnownForDTO
import com.webslinger.portfolio.moviemania.data.dto.common.DTO
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.CharacterSchema

class CharacterDTO(private val knownForDTO: KnownForDTO): DTO {
    override fun schemaToDBModel(characterSchema: NetworkModel): DBCharacterKnownFor {
        if(!CharacterSchema::class.java.isAssignableFrom(NetworkModel::class.java)){
            throw IllegalArgumentException("Invalid character schema.")
        }

        (characterSchema as CharacterSchema).apply {
            return DBCharacterKnownFor(
                DBCharacter(
                    adult,
                    gender,
                    id,
                    knownForDepartment,
                    name,
                    popularity,
                    profilePath
                ),

                knownForSchema.map {
                    knownForDTO.schemaToDBModel(it)
                }
            )
        }
    }

    override fun dbModelToSchema(dbCharacter: DataBaseModel): CharacterSchema {
        if(!DBCharacter::class.java.isAssignableFrom(NetworkModel::class.java)){
            throw IllegalArgumentException("Invalid character database model.")
        }

        (dbCharacter as DBCharacterKnownFor).apply {
            return CharacterSchema(
                character.adult,
                character.gender,
                character.id,
                knownFor.map {
                    knownForDTO.dbModelToSchema(it)
                },
                character.knownForDepartment,
                character.name,
                character.popularity,
                character.profilePath
            )
        }

    }
}