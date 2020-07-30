package com.torrentcome.lalala.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.torrentcome.lalala.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.progressBar
import kotlinx.android.synthetic.main.include_error_view.*


@AndroidEntryPoint
class SearchActivity : AppCompatActivity(R.layout.activity_search) {

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.config()
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable) {
                viewModel.onEditInputStateChanged(edit.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        viewModel.searchO.observe(this, Observer {
            when (it) {
                is SuccessSearch -> {
                    
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

    }
}
