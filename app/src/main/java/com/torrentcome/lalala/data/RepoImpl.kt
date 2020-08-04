package com.torrentcome.lalala.data

import com.torrentcome.lalala.data.api.GiphyService
import com.torrentcome.lalala.domain.Repo
import javax.inject.Inject
import javax.inject.Singleton

const val API_KEY = "zIMaCOfVT6KGmPeOb0LBvkFPiPDLhGc6"

@Singleton
class RepoImpl @Inject constructor(private var giphyService: GiphyService) : Repo {

    override fun random() =
        giphyService.random()

    override fun search(query: String) =
        giphyService.search(API_KEY, query, 25, 0, "g", "en")
}