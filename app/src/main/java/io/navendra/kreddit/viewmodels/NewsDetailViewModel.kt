package io.navendra.kreddit.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.util.Log
import io.navendra.kreddit.models.api.RedditNewsData
import io.navendra.kreddit.services.DummyDataService

class NewsDetailViewModel(app: Application) : AndroidViewModel(app){

    val data : List<RedditNewsData>? =  DummyDataService(app.applicationContext).getRedditNewsData()


    fun openPermaLink(){
        Log.d("VM", "OpenPermaLink")
    }

    fun getCurrentData(pos: Int) : RedditNewsData?{
        if(data == null) return null
        var index = 0
        if(pos<data!!.size && pos>-1){
            index = pos
        }

        return data[index]
    }

}