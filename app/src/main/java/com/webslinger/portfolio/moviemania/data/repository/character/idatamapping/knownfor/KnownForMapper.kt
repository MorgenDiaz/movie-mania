package com.webslinger.portfolio.moviemania.data.repository.character.idatamapping.knownfor

import com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor.IKnownForDbToDomainMapper
import com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor.IKnownForMapper
import com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor.IKnownForNetworkToDbMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.character.NetworkKnownFor
import com.webslinger.portfolio.moviemania.domain.KnownFor

class KnownForMapper(
    private val networkToDbMapper: IKnownForNetworkToDbMapper,
    private val dbToDomainMapper: IKnownForDbToDomainMapper,
): IKnownForMapper {
    override fun networkToDbModel(networkKnownFor: NetworkKnownFor, characterId: Int): DBKnownFor {
        networkToDbMapper.characterId = characterId
        return networkToDbMapper.map(networkKnownFor)
    }

    override fun dbToDomainModel(dbKnownFor: DBKnownFor): KnownFor {
        return dbToDomainMapper.map(dbKnownFor)
    }
}