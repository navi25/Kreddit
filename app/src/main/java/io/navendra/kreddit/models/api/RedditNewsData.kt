package io.navendra.kreddit.models.api

data class RedditNewsData(
        val author:String,
        val title:String,
        val thumbnail: String,
        val url:String,
        val subreddit:String,
        val permalink:String,
        val createdAt: Long
)

