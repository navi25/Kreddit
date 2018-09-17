package io.navendra.kreddit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.navendra.kreddit.services.DummyDataService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = DummyDataService(applicationContext).getRedditNewsData()
    }
}
