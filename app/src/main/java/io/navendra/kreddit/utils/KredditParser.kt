package io.navendra.kreddit.utils

import android.util.JsonReader
import android.util.Log
import io.navendra.kreddit.models.api.RedditNewsData

class KredditParser{

    /**
     * Custom Parse Implementation without using Moshi
     */
    fun manualParse(reader: JsonReader) : List<RedditNewsData>{
        val result = mutableListOf<RedditNewsData>()
        var author = ""
        var title = ""
        var thumbnail = ""
        var url = ""
        var subreddit = ""
        var permalink = ""
        var createdAt = 1L

        reader.beginObject()

        while (reader.hasNext()){

            if(reader.nextName() == "data"){
                reader.beginObject()
                while (reader.hasNext()){
                    if(reader.nextName() == "children"){
                        reader.beginArray()
                        while (reader.hasNext()){
                            reader.beginObject()
                            while (reader.hasNext()){
                                if(reader.nextName() == "data"){
                                    reader.beginObject()
                                    while (reader.hasNext()){
                                        when(reader.nextName()){
                                            "author" -> author = reader.nextString()
                                            "subreddit" -> subreddit = reader.nextString()
                                            "title" -> title = reader.nextString()
                                            "thumbnail" -> thumbnail = reader.nextString()
                                            "created" -> createdAt = reader.nextLong()
                                            "permalink" -> permalink = reader.nextString()
                                            "url" -> url = reader.nextString()
                                            else -> reader.skipValue()
                                        }
                                    }
                                    val data = RedditNewsData(author,title,thumbnail,url, subreddit, permalink, createdAt)
                                    result.add(data)
                                    reader.endObject()
                                }else{
                                    reader.skipValue()
                                }

                            }
                            reader.endObject()
                        }
                        reader.endArray()
                    }
                    else{
                        reader.skipValue()
                    }
                }
                reader.endObject()
            }
            else {
                reader.skipValue()
            }
        }
        reader.endObject()
        Log.d("MoshiParser", "Size of ResponseArray = ${result.size}")
        return result
    }

    fun moshiParse(reader: JsonReader) : List<RedditNewsData>{
        return emptyList()
    }

}