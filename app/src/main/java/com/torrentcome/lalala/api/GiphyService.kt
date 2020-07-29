package com.torrentcome.lalala.api

import com.torrentcome.lalala.dto.Wrapper
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

// random
// https://api.giphy.com/v1/gifs/random?api_key=zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6&tag=&rating=pg-13

// search
// https://api.giphy.com/v1/gifs/search?api_key=zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6&q=coucou&limit=25&offset=0&rating=g&lang=en

interface GiphyService {

    @GET("gifs/random?api_key=zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6&tag=&rating=g")
    fun random(): Observable<Wrapper?>?

    @GET("gifs/search?api_key=zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6&q={q}&limit=25&offset=0&rating=g&lang=en")
    fun search(@Path("q") text: String): Observable<Wrapper?>?
}