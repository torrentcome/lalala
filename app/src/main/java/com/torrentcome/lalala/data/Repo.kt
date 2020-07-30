package com.torrentcome.lalala.data

import com.torrentcome.lalala.api.GiphyService
import javax.inject.Inject
import javax.inject.Singleton

const val API_KEY = "zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6"

@Singleton
class Repo @Inject constructor(var giphyService: GiphyService) {

    fun random() =
        giphyService.random()

    fun search(query: String) =
        giphyService.search(API_KEY, query, 25, 0, "g", "en")
}