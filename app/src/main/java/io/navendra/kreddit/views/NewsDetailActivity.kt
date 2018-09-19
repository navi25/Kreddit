package io.navendra.kreddit.views

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.github.ajalt.timberkt.Timber
import io.navendra.kreddit.App
import io.navendra.kreddit.R
import io.navendra.kreddit.viewmodels.NewsDetailViewModel
import kotlinx.android.synthetic.main.activity_news_detail.*
import android.content.Intent
import android.net.Uri
import io.navendra.kreddit.models.api.RedditNewsData
import kotlinx.android.synthetic.main.activity_news_detail.view.*


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class NewsDetailActivity : Activity() {

    lateinit var mViewModel : NewsDetailViewModel

    var currentPos = 0
    var currentData : RedditNewsData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        card_view.setOnTouchListener(listener(this) )
        mViewModel = (application as App).getViewModel()
        setupCurrentCard()
    }

    fun setupCurrentCard(){
        currentData = mViewModel.getCurrentData(currentPos)
        if(currentData==null) {
            Timber.d{ "Current Data is null"}
        }
        card_view.apply {
            title.text = currentData?.title
            desc.text = currentData?.subreddit
        }
    }

    inner class listener(context:Context) : OnSwipeTouchListener(context){
        override fun onSwipeRight() {
            Timber.d { "onSwipeRight" }

        }

        override fun onSwipeLeft() {
            Timber.d { "onSwipeLeft" }
            Timber.d{ "The permalink is ${currentData?.permalink}"}
            val url = "https://www.reddit.com/" + currentData?.permalink
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }

        override fun onSwipeTop() {
            currentPos++
            setupCurrentCard()
            Timber.d { "onSwipeTop" }
        }

        override fun onSwipeBottom() {
            currentPos--
            setupCurrentCard()
            Timber.d { "onSwipeBottom" }

        }

    }
}
