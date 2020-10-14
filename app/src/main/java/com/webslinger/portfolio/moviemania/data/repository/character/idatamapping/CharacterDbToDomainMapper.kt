package com.webslinger.portfolio.moviemania.data.repository.character.idatamapping

import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor.IKnownForMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.domain.Character

class CharacterDbToDomainMapper(private val knownForMapper: IKnownForMapper): ICharacterDbToDomainMapper {
    override fun map(input: DBCharacterKnownFor): Character {
        input.apply {
            return Character(
                character.adult,
                character.gender,
                character.id,
                knownFor.map {
                    knownForMapper.dbToDomainModel(it)
                },
                character.knownForDepartment,
                character.name,
                character.popularity,
                character.profilePath
            )
        }
    }
}