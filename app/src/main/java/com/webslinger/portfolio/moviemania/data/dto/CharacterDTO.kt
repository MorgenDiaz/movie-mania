package com.webslinger.portfolio.moviemania.data.dto

import com.webslinger.portfolio.moviemania.data.db.character.DBCharacter
import com.webslinger.portfolio.moviemania.data.dto.common.DTO
import com.webslinger.portfolio.moviemania.data.dto.common.DataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.NetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.CharacterSchema

class CharacterDTO: DTO {
    override fun schemaToDBModel(characterSchema: NetworkModel): DBCharacter {
        if(!CharacterSchema::class.java.isAssignableFrom(NetworkModel::class.java)){
            throw IllegalArgumentException("Invalid character schema.")
        }

        (characterSchema as CharacterSchema).apply {
            return DBCharacter(
                adult,
                gender,
                id,
                knownForSchema,
                knownForDepartment,
                name,
                popularity,
                profilePath
            )
        }
    }

    override fun dbModelToSchema(dbCharacter: DataBaseModel): CharacterSchema {
        if(!DBCharacter::class.java.isAssignableFrom(NetworkModel::class.java)){
            throw IllegalArgumentException("Invalid character database model.")
        }

        (dbCharacter as DBCharacter).apply {
            return CharacterSchema(
                adult,
                gender,
                id,
                knownFor,
                knownForDepartment,
                name,
                popularity,
                profilePath
            )
        }

    }
}