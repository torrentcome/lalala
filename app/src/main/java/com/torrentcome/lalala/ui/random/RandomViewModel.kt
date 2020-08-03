package com.torrentcome.lalala.ui.random

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.torrentcome.lalala.data.RepoImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class RandomViewModel @ViewModelInject constructor(private val repository: RepoImpl) : ViewModel() {

    sealed class Command {
        object Start : Command()
        object Loading : Command()
        data class Fail(val message: String = "") : Command()
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
        .subscribe({ wrapper ->
            wrapper?.data?.images?.original?.url?.let {
                _random.postValue(Command.Success(it))
            }
        }, {
            _random.postValue(Command.Fail(it.message.toString()))
        })
    )

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
