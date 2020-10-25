package com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor

import com.webslinger.portfolio.moviemania.data.db.actor.DBKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkKnownFor
import com.webslinger.portfolio.moviemania.domain.model.KnownFor

interface IKnownForMapper {
    fun networkToDbModel(networkKnownFor: NetworkKnownFor, characterId: Int): DBKnownFor
    fun dbToDomainModel(dbKnownFor: DBKnownFor): KnownFor
}