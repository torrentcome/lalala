package com.torrentcome.lalala.dto

data class Wrapper(val data: Data)
data class Data(val images: Images)
data class Images(val original: Original)
data class Original(val height: String, val url: String, val width: String)