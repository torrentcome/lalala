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
import com.torrentcome.lalala.domain.dto.Data
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

    private lateinit var adapter: GifListAdapter
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.config()

        adapter = GifListAdapter { gif -> goToDetail(gif) }
        recycler_view.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycler_view.adapter = adapter

        edit.requestFocus()
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable) {
                viewModel.onEditInputStateChanged(edit.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.searchO.observe(this, Observer {
            when (it) {
                is SearchViewModel.Command.Success -> {
                    adapter.list = it.list
                    progressBar.visibility = View.GONE
                }
                is SearchViewModel.Command.Fail -> {
                    error.visibility = View.VISIBLE
                    error_message.text = it.message
                    progressBar.visibility = View.GONE
                }
                is SearchViewModel.Command.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is SearchViewModel.Command.Empty -> {
                    progressBar.visibility = View.GONE
                }
                is SearchViewModel.Command.Start -> {
                }
                null -> {
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
