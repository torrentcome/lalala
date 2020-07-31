package com.torrentcome.lalala.ui.random

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.torrentcome.lalala.data.Repo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class RandomViewModel @ViewModelInject constructor(private val repository: Repo) : ViewModel() {

    sealed class Command {
        object Start : Command()
        object Loading : Command()
        object Fail : Command()
        data class Success(val url: String = "") : Command()
    }

    // subscription
    private val disposables by lazy { CompositeDisposable() }

    // mutable
    private val _random = MutableLiveData<Command>()

    // visible
    val randomO: LiveData<Command> = _random


    init {
        _random.postValue(Command.Start)
    }

    fun getRandom() = disposables.add(repository.random()
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
        .doOnSubscribe { _random.postValue(Command.Loading) }
        .doOnError {
            it.printStackTrace()
            _random.postValue(Command.Fail)
        }
        .subscribe { wrapper ->
            wrapper?.data?.images?.original?.url?.let {
                _random.postValue(Command.Success(it))
            }
        })

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
