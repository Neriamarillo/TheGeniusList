package com.jn769.thegeniuslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        fetchJson()

    }

    private fun fetchJson() {

        val requestUrl = "https://reqres.in/api/users"

        val request = Request.Builder().url(requestUrl).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")

            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                println(body)

                val gson = GsonBuilder().create()

                val userList = gson.fromJson(body, Data::class.java)

                runOnUiThread {
                    recyclerView_main.adapter = UserAdapter(userList)
                }
            }
        })

    }


}
