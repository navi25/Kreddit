package io.navendra.kreddit.views

import android.app.Activity
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.NavUtils
import android.support.v4.view.MotionEventCompat
import android.util.Log
import android.view.*
import com.github.ajalt.timberkt.Timber
import io.navendra.kreddit.App
import io.navendra.kreddit.MainActivity
import io.navendra.kreddit.R
import io.navendra.kreddit.viewmodels.NewsDetailViewModel
import kotlinx.android.synthetic.main.activity_news_detail.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class NewsDetailActivity : Activity() {

    lateinit var mViewModel : NewsDetailViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        card_view.setOnTouchListener(listener(this) )
        mViewModel = (application as App).getViewModel()
    }

    inner class listener(context:Context) : OnSwipeTouchListener(context){
        override fun onSwipeRight() {
            Timber.d { "onSwipeRight" }

        }

        override fun onSwipeLeft() {
            Timber.d { "onSwipeLeft" }
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(browserIntent)
        }

        override fun onSwipeTop() {
            Timber.d { "onSwipeTop" }
//
        }

        override fun onSwipeBottom() {
            Timber.d { "onSwipeBottom" }

        }

    }
}
