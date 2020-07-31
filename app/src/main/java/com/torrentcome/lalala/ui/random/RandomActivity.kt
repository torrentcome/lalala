package com.torrentcome.lalala.ui.random

import android.content.Context
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
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.torrentcome.lalala.R
import com.torrentcome.lalala.ui.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_random.*
import kotlinx.android.synthetic.main.include_error_view.*


@AndroidEntryPoint
class RandomActivity : AppCompatActivity(R.layout.activity_random) {
    private val viewModel: RandomViewModel by viewModels()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getRandom()
        viewModel.randomO.observe(this, Observer {
            when (it) {
                is RandomViewModel.Command.Success -> {
                    Log.e("observe", "" + it.url)
                    Glide.with(this)
                        .load(it.url)
                        .apply(RequestOptions().placeholder(R.drawable.place_holder))
                        .listener(requestListener {
                            progressBar.visibility = View.GONE
                            button.visibility = View.VISIBLE
                        })
                        .into(imageView)
                }
                is RandomViewModel.Command.Fail -> {

                    error.visibility = View.VISIBLE
                    error_message.text = it.message

                    progressBar.visibility = View.GONE
                }
                is RandomViewModel.Command.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                else -> {
                }
            }
        })

        button.setOnClickListener {
            goToSearchActivity()
            finish()
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
