package com.jn769.thegeniuslist

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Jorge Nieves on 2019-10-21.
 */
object ApiClient {

    private const val BASE_URL = "https://reqres.in"

    private val client = OkHttpClient.Builder().build()

    val instance: ApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        retrofit.create(ApiInterface::class.java)
    }
}