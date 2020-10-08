package com.webslinger.portfolio.moviemania.data.dto.character

import com.webslinger.portfolio.moviemania.data.db.character.DBCharacter
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.dto.character.knownfor.KnownForDTO
import com.webslinger.portfolio.moviemania.data.dto.common.IDataBaseModel
import com.webslinger.portfolio.moviemania.data.dto.common.INetworkModel
import com.webslinger.portfolio.moviemania.data.networking.schema.character.CharacterSchema
import com.webslinger.portfolio.moviemania.domain.Character

class CharacterDTO(private val knownForDTO: KnownForDTO): ICharacterDTO {
    override fun schemaToDBModel(networkModel: INetworkModel): DBCharacterKnownFor {
        if(!CharacterSchema::class.java.isAssignableFrom(INetworkModel::class.java)){
            throw IllegalArgumentException("Invalid character schema.")
        }

        (networkModel as CharacterSchema).apply {
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

    override fun dbModelToSchema(dbModel: IDataBaseModel): CharacterSchema {
        if(!DBCharacter::class.java.isAssignableFrom(INetworkModel::class.java)){
            throw IllegalArgumentException("Invalid character database model.")
        }

        (dbModel as DBCharacterKnownFor).apply {
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

    override fun dbModelToDomain(dbModel: IDataBaseModel): Character {
        TODO("Not yet implemented")
    }
}