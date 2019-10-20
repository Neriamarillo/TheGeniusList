package com.jn769.thegeniuslist

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import okhttp3.RequestBody.Companion.toRequestBody

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {

            // Sample string for testing POST Response
            addUser("George Costanza")
        }


        fetchJson()


    }

    private fun fetchJson() {

        val requestUrl = "https://reqres.in/api/users"
        val request = Request.Builder().url(requestUrl).build()
        val client = OkHttpClient()

        // Asynchronous GET task using enqueue
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e)

            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

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

    private fun addUser(user: String) {

        val client = OkHttpClient()
        val requestUrl = "https://reqres.in/api/users"
        val postBody = user.toRequestBody()
        val request = Request.Builder()
            .method("POST", postBody)
            .url(requestUrl)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e)

            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                println(response)
                runOnUiThread {

                    // Small dialog to display Status Code for confirmation of POST request success
                    val dialogBuilder = AlertDialog.Builder(this@MainActivity)
                    dialogBuilder
                        .setTitle("POST Request")
                        .setMessage("Status Code: " + response.code)
                        .setNegativeButton(
                            "Ok"
                        ) { dialog, _ -> dialog.cancel() }
                        .show()

                }

                // GET the data again from the server to reflect the newly added item.
                fetchJson()

            }

        })

    }

    override fun onRestart() {
        super.onRestart()
        fetchJson()
    }


}
