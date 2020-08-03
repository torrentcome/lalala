package com.torrentcome.lalala.data

import com.torrentcome.lalala.api.GiphyService
import com.torrentcome.lalala.dto.RandomObj
import com.torrentcome.lalala.dto.SearchObj
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Singleton

const val API_KEY = "zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6"

/** domain **/
interface Repo {
    fun random(): Observable<RandomObj?>
    fun search(query: String): Observable<SearchObj?>
}

@Singleton
class RepoImpl @Inject constructor(private var giphyService: GiphyService) : Repo {

    override fun random() =
        giphyService.random()

    override fun search(query: String) =
        giphyService.search(API_KEY, query, 25, 0, "g", "en")
}