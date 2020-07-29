package com.torrentcome.lalala.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.torrentcome.lalala.R
import com.torrentcome.lalala.data.Repo
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var repository: Repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository.random()
                ?.subscribeOn(Schedulers.io())
                ?.subscribe { wrapper ->
            Log.e("yo", "" + wrapper)
        }

        Log.e("yo", "" + repository.ok())
    }
}
