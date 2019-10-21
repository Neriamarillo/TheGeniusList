package com.jn769.thegeniuslist

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


/**
 * Created by Jorge Nieves on 2019-10-19.
 */


class UserList {

    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("per_page")
    @Expose
    var perPage: Int? = null
    @SerializedName("total")
    @Expose
    var total: Int? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("data")
    @Expose
    var data: List<Data>? = null

    class Data {
        @SerializedName("first_name")
        val firstName: String = ""
        @SerializedName("last_name")
        val lastName: String = ""
        @SerializedName("email")
        val email: String = ""
        @SerializedName("avatar")
        val avatarUrl: String? = null
    }

}

class User {
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("job")
    @Expose
    private var job: String? = null

    constructor(name: String, job: String) {
        this.name = name
        this.job = job

    }

}