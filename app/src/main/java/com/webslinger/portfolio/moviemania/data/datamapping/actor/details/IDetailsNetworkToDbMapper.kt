package com.webslinger.portfolio.moviemania.data.datamapping.actor.details

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBActorDetails
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDetails

interface IDetailsNetworkToDbMapper: IDataMapper<NetworkActorDetails, DBActorDetails> {
}