package com.webslinger.portfolio.moviemania.data.datamapping.actor.knownfor

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBKnownFor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkKnownFor

interface IKnownForNetworkToDbMapper: IDataMapper<NetworkKnownFor, DBKnownFor>{
    var actorId: Int
}