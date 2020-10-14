package com.webslinger.portfolio.moviemania.data.repository.character.idatamapping

import com.webslinger.portfolio.moviemania.data.datamapping.character.ICharacterNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor.IKnownForMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacter
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkCharacter

class CharacterNetworkToDbMapper(private val knownForMapper: IKnownForMapper): ICharacterNetworkToDbMapper {
    override fun map(input: NetworkCharacter): DBCharacterKnownFor {
        input.apply {
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
                networkKnownFor.map {
                    knownForMapper.networkToDbModel(it, id)
                }
            )
        }
    }
}