package io.navendra.kreddit.utils

import android.content.Context
import android.util.JsonReader
import io.navendra.kreddit.models.api.RedditNewsData

class DummyDataFactory(private val mContext : Context){

    fun getRedditNewsData() :List<RedditNewsData>?  {
        val inputStream = mContext.assets.open("redditData.json")
        val jsonReader = JsonReader(inputStream.reader())
        return KredditParser().manualParse(jsonReader)
    }


}