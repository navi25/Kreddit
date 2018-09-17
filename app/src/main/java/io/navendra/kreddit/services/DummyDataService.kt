package io.navendra.kreddit.services

import android.content.Context
import io.navendra.kreddit.models.api.RedditNewsData
import io.navendra.kreddit.utils.DummyDataFactory

class DummyDataService(private val context: Context) : IDataService{

    override fun getRedditNewsData(): List<RedditNewsData>? {
        return DummyDataFactory(context).getRedditNewsData()
    }

}