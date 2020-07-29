package com.torrentcome.lalala.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.torrentcome.lalala.data.Repo

class MainViewModel @ViewModelInject constructor(private val repository: Repo) : ViewModel() {

    fun getRandom() = repository.random()

    fun search(text: String) = repository.search(text)
}