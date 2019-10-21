package com.jn769.thegeniuslist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {

            // Sample string for testing POST Response
            addUser("George Costanza", "Manager")
        }

        getUsers()

    }


    private fun getUsers() {
        val service = ApiClient.instance
        val call = service.getUserList()

        call.enqueue(object : retrofit2.Callback<UserList> {
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<UserList>,
                response: Response<UserList>
            ) {
                val userList = response.body()
                val page = userList?.page
                val total = userList?.total
                val totalPages = userList?.totalPages
                val dataList = userList?.data

                runOnUiThread {
                    recyclerView_main.adapter = UserAdapter(dataList)
                }

            }

        })

    }


    private fun addUser(userName: String, job: String) {

        val service = ApiClient.instance
        val newUser = User(userName, job)
        val call = service.createUser(newUser)

        call.enqueue(object : retrofit2.Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext, "Error creating new user", Toast.LENGTH_LONG)
                    .show()

            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                runOnUiThread {

                    // Small dialog to display Status Code for confirmation of POST request success
                    val dialogBuilder = AlertDialog.Builder(this@MainActivity)
                    dialogBuilder
                        .setTitle("POST Request")
                        .setMessage("Status Code: " + response.code())
                        .setNegativeButton(
                            "Ok"
                        ) { dialog, _ -> dialog.cancel() }
                        .show()

                }

            }

        })

    }

    override fun onRestart() {
        super.onRestart()
        getUsers()
    }


}
