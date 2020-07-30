package com.torrentcome.lalala.ui.random

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.torrentcome.lalala.R
import com.torrentcome.lalala.ui.random.Fail
import com.torrentcome.lalala.ui.random.Loading
import com.torrentcome.lalala.ui.random.MainViewModel
import com.torrentcome.lalala.ui.random.SuccessRandom
import com.torrentcome.lalala.ui.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_error_view.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getRandom()
        viewModel.randomO.observe(this, Observer {
            when (it) {
                is SuccessRandom -> {
                    Log.e("observe", "" + it.url)
                    Glide.with(this)
                        .load(it.url)
                        .listener(requestListener {
                            progressBar.visibility = View.GONE
                            button.visibility = View.VISIBLE
                        })
                        .into(imageView)
                }
                is Fail -> {
                    error.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
                is Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
            }
        })

        button.setOnClickListener {
            goToSearchActivity()
        }
    }

    private fun goToSearchActivity() {
        val myIntent = Intent(this, SearchActivity::class.java)
        this.startActivity(myIntent)
    }

    private fun requestListener(block: () -> Unit): RequestListener<Drawable> {
        return object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                block.invoke()
                return false
            }
        }
    }
}
