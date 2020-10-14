package com.webslinger.portfolio.moviemania.data.datamapping.character

import com.webslinger.portfolio.moviemania.data.datamapping.common.IDataMapper
import com.webslinger.portfolio.moviemania.data.db.character.DBCharacterKnownFor
import com.webslinger.portfolio.moviemania.domain.Character

interface ICharacterDbToDomainMapper: IDataMapper<DBCharacterKnownFor, Character>