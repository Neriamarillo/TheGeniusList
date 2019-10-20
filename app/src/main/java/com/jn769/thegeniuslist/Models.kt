package com.jn769.thegeniuslist

import com.google.gson.annotations.SerializedName

/**
 * Created by Jorge Nieves on 2019-10-19.
 */
class Data(val data: List<User>)

class User(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("avatar")
    val avatarUrl: String
)