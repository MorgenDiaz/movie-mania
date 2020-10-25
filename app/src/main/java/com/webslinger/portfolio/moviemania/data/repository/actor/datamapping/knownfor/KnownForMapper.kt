package com.webslinger.portfolio.moviemania.data.repository.actor.datamapping.knownfor

import com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor.IKnownForDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor.IKnownForMapper
import com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor.IKnownForNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkKnownFor
import com.webslinger.portfolio.moviemania.domain.model.KnownFor

class KnownForMapper(
    private val networkToDbMapper: IKnownForNetworkToDbMapper,
    private val dbToDomainMapper: IKnownForDbToDomainMapper,
): IKnownForMapper {
    override fun networkToDbModel(networkKnownFor: NetworkKnownFor, characterId: Int): DBKnownFor {
        networkToDbMapper.actorId = characterId
        return networkToDbMapper.map(networkKnownFor)
    }

    override fun dbToDomainModel(dbKnownFor: DBKnownFor): KnownFor {
        return dbToDomainMapper.map(dbKnownFor)
    }
}