package com.torrentcome.lalala.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jakewharton.rxrelay3.PublishRelay
import com.torrentcome.lalala.data.RepoImpl
import com.torrentcome.lalala.domain.dto.Data
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class SearchViewModel @ViewModelInject constructor(private val repository: RepoImpl) : ViewModel() {

    sealed class Command {
        object Start : Command()
        object Loading : Command()
        class Fail(val message: String) : Command()
        object Empty : Command()
        data class Success(val list: List<Data> = emptyList()) : Command()
    }

    // subscription
    private val disposables by lazy { CompositeDisposable() }
    private val completePublishSubject by lazy { PublishRelay.create<String>() }

    // mutable var
    private val _search = MutableLiveData<Command?>()

    // visible var
    val searchO: LiveData<Command?> = _search

    init {
        _search.postValue(Command.Start)
    }

    fun onEditInputStateChanged(query: String) {
        println("search = $query")
        if (query.isNotEmpty())
            completePublishSubject.accept(query.trim())
    }

    fun config() {
        disposables.add(completePublishSubject
                .debounce(400, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap {
                    repository.search(it).doOnSubscribe { _search.postValue(Command.Loading) }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe({ wrapper ->
                    println("search=" + "" + wrapper.toString())
                    wrapper?.data?.let {
                        if (it.isEmpty()) _search.postValue(Command.Empty)
                        else _search.postValue(Command.Success(it))
                    }
                }, {
                    _search.postValue(Command.Fail(it.message.toString()))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
