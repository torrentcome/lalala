package com.torrentcome.lalala.ui.random

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.torrentcome.lalala.data.Repo
import com.torrentcome.lalala.dto.Data
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainViewModel @ViewModelInject constructor(private val repository: Repo) : ViewModel() {

    // subscription
    private var disposable: CompositeDisposable? = CompositeDisposable()

    // mutable var
    private val _random = MutableLiveData<Command?>()

    // visible var
    val randomO: LiveData<Command?> = _random

    fun getRandom() = disposable?.add(repository.random()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe {
            _random.value = Loading
        }
        .doOnError {
            it.printStackTrace()
            _random.value = Fail
        }
        .subscribe { wrapper ->
            wrapper?.data?.images?.original?.url.let {
                _random.value =
                    SuccessRandom(it)
            }
        })

    override fun onCleared() {
        super.onCleared()
        disposable?.clear()
        disposable = null
    }
}

open class Command
class SuccessRandom(val url: String?) : Command()
class SuccessSearch(val list: List<Data>?) : Command()
object Loading : Command()
object Fail : Command()