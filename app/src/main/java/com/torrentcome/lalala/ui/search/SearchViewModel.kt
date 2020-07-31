package com.torrentcome.lalala.ui.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jakewharton.rxrelay3.PublishRelay
import com.torrentcome.lalala.data.Repo
import com.torrentcome.lalala.dto.Data
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class SearchViewModel @ViewModelInject constructor(private val repository: Repo) : ViewModel() {

    sealed class Command {
        object Loading : Command()
        object Fail : Command()
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

    fun onEditInputStateChanged(query: String) {
        Log.e("search", "" + query)
        if (query.isNotEmpty())
            completePublishSubject.accept(query.trim())
    }

    fun config() {
        disposables.add(completePublishSubject
            .debounce(400, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap { repository.search(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _search.value = Command.Loading }
            .doOnError { _search.value = Command.Fail }
            .subscribe { wrapper ->
                Log.e("search", "" + wrapper.toString())
                wrapper?.data?.let {
                    if (it.isEmpty()) _search.value = Command.Empty
                    else _search.value = Command.Success(it)
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
