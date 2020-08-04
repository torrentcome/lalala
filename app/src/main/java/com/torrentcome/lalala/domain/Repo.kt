package com.torrentcome.lalala.domain

import com.torrentcome.lalala.domain.dto.RandomObj
import com.torrentcome.lalala.domain.dto.SearchObj
import io.reactivex.rxjava3.core.Observable

interface Repo {
    fun random(): Observable<RandomObj?>
    fun search(query: String): Observable<SearchObj?>
}