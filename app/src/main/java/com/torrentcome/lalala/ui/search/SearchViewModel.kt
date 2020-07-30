package com.torrentcome.lalala.ui.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jakewharton.rxrelay3.PublishRelay
import com.torrentcome.lalala.base.*
import com.torrentcome.lalala.data.Repo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class SearchViewModel @ViewModelInject constructor(private val repository: Repo) : ViewModel() {

    // subscription
    private var disposable: CompositeDisposable? = CompositeDisposable()
    private val completePublishSubject = PublishRelay.create<String>()

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
        completePublishSubject
            .debounce(400, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap { repository.search(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _search.value = Loading }
            .doOnError { _search.value = Fail }
            .subscribe { wrapper ->
                Log.e("search", "" + wrapper.toString())
                wrapper?.data?.let {
                    if (it.isEmpty()) _search.value = Empty
                    else _search.value = SuccessSearch(it)
                }
            }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.clear()
        disposable = null
    }

}
