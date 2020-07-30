package com.torrentcome.lalala.dto

data class RandomObj(val data: Data)
data class Data(val images: Images)
data class Images(val original: Original)
data class Original(val height: String, val url: String, val width: String)

data class SearchObj(val data: List<Data>)