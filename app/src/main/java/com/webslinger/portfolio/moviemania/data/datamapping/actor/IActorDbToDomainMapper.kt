package com.webslinger.portfolio.moviemania.data.datamapping.actor

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.actor.DBDetailedActor
import com.webslinger.portfolio.moviemania.domain.model.Actor

interface IActorDbToDomainMapper: IDataMapper<DBDetailedActor, Actor>