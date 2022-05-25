package es.mrmoustard.data.source.remote.api

import es.mrmoustard.data.source.remote.entities.TownEntity
import retrofit2.http.GET

interface BrastlewarkApi {

    @GET("master/data.json")
    suspend fun getPopulation(): TownEntity
}