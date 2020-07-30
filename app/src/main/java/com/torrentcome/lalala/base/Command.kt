package com.torrentcome.lalala.base

import com.torrentcome.lalala.dto.Data

open class Command

// generic
object Loading : Command()
object Fail : Command()
object Empty : Command()

// random
class SuccessRandom(val url: String?) : Command()

// search
class SuccessSearch(val list: List<Data>?) : Command()
