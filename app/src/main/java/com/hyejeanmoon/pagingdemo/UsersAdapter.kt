package com.hyejeanmoon.pagingdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hyejeanmoon.pagingdemo.databinding.ItemUsersBinding

class UsersAdapter : PagedListAdapter<User, UsersAdapter.UserViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemUsersBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_users, parent, false)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.also {
            holder.binding.txtBirthday.text = it.birthday
            holder.binding.txtFirstName.text = it.firstName
            holder.binding.txtLastName.text = it.lastName
            holder.binding.txtNationality.text = it.nationality
        }
    }

    class UserViewHolder(var binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem === newItem
            }
        }
    }
}