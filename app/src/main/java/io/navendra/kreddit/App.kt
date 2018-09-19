package io.navendra.kreddit

import android.app.Application
import io.navendra.kreddit.services.TimberLogging
import io.navendra.kreddit.viewmodels.NewsDetailViewModel


class App : Application(){

    init {
        TimberLogging()
    }

    fun getViewModel(): NewsDetailViewModel {
        return NewsDetailViewModel(this)
    }


}