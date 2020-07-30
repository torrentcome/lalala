package com.torrentcome.lalala.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.torrentcome.lalala.R
import com.torrentcome.lalala.utils.OnSwipeListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail.*


@AndroidEntryPoint
class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    var gestureDetectorCompat: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = intent.extras?.getString("url")

        imageView.setOnTouchListener { _, p1 ->
            gestureDetectorCompat?.onTouchEvent(p1)!!
        }

        gestureDetectorCompat = GestureDetectorCompat(this, object : OnSwipeListener() {
            override fun onSwipe(direction: Direction?): Boolean {
                if (direction == Direction.left) {
                    onBackPressed()
                }
                if (direction == Direction.up) {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Lalala share")
                    val shareMessage = "\nLet me recommend you this gify\n"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                    startActivity(Intent.createChooser(shareIntent, "choose one"))
                }
                return super.onSwipe(direction)
            }
        })

        Glide.with(this)
            .load(url)
            .apply(RequestOptions().placeholder(R.drawable.place_holder))
            .into(imageView)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetectorCompat?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }
}