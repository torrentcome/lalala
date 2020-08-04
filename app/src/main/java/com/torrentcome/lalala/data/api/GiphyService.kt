package com.torrentcome.lalala.data.api

import com.torrentcome.lalala.domain.dto.RandomObj
import com.torrentcome.lalala.domain.dto.SearchObj
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService {

    @GET("gifs/random?api_key=zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6&tag=&rating=g")
    fun random(): Observable<RandomObj?>

    @GET("gifs/search")
    fun search(
        @Query("api_key") api_key: String,
        @Query("q") q: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("lang") lang: String
    ): Observable<SearchObj?>
}