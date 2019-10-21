package com.jn769.thegeniuslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapter(private val userList: List<UserList.Data>?) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_row, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return userList?.count()!!

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList?.get(position)
        holder.itemView.textView_user_name.text = user?.firstName + " " + user?.lastName
        holder.itemView.textView_email.text = user?.email

        val imageView = holder.itemView.imageView_avatar
        Picasso.get().load(user?.avatarUrl).into(imageView)

    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}
