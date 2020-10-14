package com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor

import com.webslinger.portfolio.moviemania.data.db.character.DBKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkKnownFor
import com.webslinger.portfolio.moviemania.domain.KnownFor

interface IKnownForMapper {
    fun networkToDbModel(networkKnownFor: NetworkKnownFor, characterId: Int): DBKnownFor
    fun dbToDomainModel(dbKnownFor: DBKnownFor): KnownFor
}