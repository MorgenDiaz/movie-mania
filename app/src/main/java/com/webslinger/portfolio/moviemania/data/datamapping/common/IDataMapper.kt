package com.webslinger.portfolio.moviemania.data.datamapping.common

interface IDataMapper<I, O> {
    fun map(input: I): O
}