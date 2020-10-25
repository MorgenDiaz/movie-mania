package com.webslinger.portfolio.moviemania.data.datamapping.actor

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.data.networking.model.actor.NetworkActorDTO

interface IActorNetworkToDbMapper: IDataMapper<NetworkActorDTO, DBDetailedActor>