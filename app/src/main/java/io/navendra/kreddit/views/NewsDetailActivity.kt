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
import io.navendra.kreddit.MainActivity
import io.navendra.kreddit.R
import io.navendra.kreddit.viewmodels.NewsDetailViewModel
import kotlinx.android.synthetic.main.activity_news_detail.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class NewsDetailActivity : Activity() {

    val TAG = NewsDetailActivity::class.java.simpleName

    lateinit var viewModel : NewsDetailViewModel

    class listener(context:Context) : OnSwipeTouchListener(context){
        override fun onSwipeRight() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSwipeLeft() {

        }

        override fun onSwipeTop() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSwipeBottom() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        card_view.setOnTouchListener(listener(this) )
//        viewModel = ViewModelProvider
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }




    fun swipeUp(){}

    fun swipeDown(){}

    fun swipeRight(){}

    fun swipeLeft(){}



    companion object {
        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private val UI_ANIMATION_DELAY = 300
    }
}
