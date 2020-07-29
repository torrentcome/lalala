package com.torrentcome.lalala.data

import com.torrentcome.lalala.api.GiphyService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repo @Inject constructor(var giphyService: GiphyService) {
    fun ok(): String = "show up"

    fun random() = giphyService.random()

    fun search(text: String) = giphyService.search(text)
}