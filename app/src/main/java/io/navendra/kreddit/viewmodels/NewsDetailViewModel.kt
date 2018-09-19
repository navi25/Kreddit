package io.navendra.kreddit.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log

class NewsDetailViewModel(app: Application) : AndroidViewModel(app){

    fun openPermaLink(){
        Log.d("VM", "OpenPermaLink")
    }

}