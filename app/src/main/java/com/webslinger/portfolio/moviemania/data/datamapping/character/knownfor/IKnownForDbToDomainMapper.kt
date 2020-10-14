package com.webslinger.portfolio.moviemania.data.datamapping.character.knownfor

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBKnownFor
import com.webslinger.portfolio.moviemania.domain.KnownFor

interface IKnownForDbToDomainMapper: IDataMapper<DBKnownFor, KnownFor>