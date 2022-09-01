package com.ashr.cleanMvvmSocket.remote.mapper

interface EntityMapper<in REMOTE, out Entity> {

    fun mapFromRemote(type: REMOTE): Entity
}