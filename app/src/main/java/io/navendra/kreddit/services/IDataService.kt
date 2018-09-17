package io.navendra.kreddit.services

import io.navendra.kreddit.models.api.RedditNewsData

interface IDataService {
    fun getRedditNewsData() : List<RedditNewsData>?

}