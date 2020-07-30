package com.torrentcome.lalala.ui.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.torrentcome.lalala.R
import com.torrentcome.lalala.base.Empty
import com.torrentcome.lalala.base.Fail
import com.torrentcome.lalala.base.Loading
import com.torrentcome.lalala.base.SuccessSearch
import com.torrentcome.lalala.dto.Data
import com.torrentcome.lalala.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.include_error_view.*


@AndroidEntryPoint
class SearchActivity : AppCompatActivity(R.layout.activity_search) {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.config()

        val adapter = GifListAdapter { gif -> goToDetail(gif) }

        recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycler_view.adapter = adapter

        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable) {
                viewModel.onEditInputStateChanged(edit.text.toString())
                progressBar.visibility = View.VISIBLE
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.searchO.observe(this, Observer {
            when (it) {
                is SuccessSearch -> {
                    adapter.list = it.list!!
                    progressBar.visibility = View.GONE
                }
                is Fail -> {
                    error.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
                is Loading -> {
                }
                is Empty -> {
                }
            }
        })
    }

    private fun goToDetail(gif: Data) {
        gif.images.original.url.let {
            Log.i("list", "" + it)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("url", it)
            Log.i("intent", "" + intent)
            this.startActivity(intent)
        }
    }
}
