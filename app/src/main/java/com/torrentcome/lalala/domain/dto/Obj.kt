package com.torrentcome.lalala.domain.dto

// random
data class RandomObj(val data: Data)

// search
data class SearchObj(val data: List<Data>)

// generic
data class Data(val images: Images)
data class Images(val original: Original)
data class Original(val height: String, val url: String, val width: String)
