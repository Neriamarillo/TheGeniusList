package com.jn769.thegeniuslist

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Jorge Nieves on 2019-10-21.
 */
interface ApiInterface {

    @GET("/api/users?")
    fun getUserList() : Call<UserList>

    @POST("/api/users")
    fun createUser(@Body user: User) : Call<User>

}