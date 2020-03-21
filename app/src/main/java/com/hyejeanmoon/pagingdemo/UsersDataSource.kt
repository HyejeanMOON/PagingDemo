package com.hyejeanmoon.pagingdemo

import androidx.paging.PageKeyedDataSource

class UsersDataSource : PageKeyedDataSource<Int, User>() {

    private var currentPage = 0
    private var users: List<User>

    init {
        users = generateUser()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, User>
    ) {

        callback.onResult(getList(0), null, 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        callback.onResult(getList(currentPage), currentPage--)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        callback.onResult(getList(currentPage), currentPage++)
    }

    private fun generateUser(): List<User> {
        var users: ArrayList<User> = ArrayList()

        val firstNamePrefix = "firstName "
        val lastNamePrefix = "lastName "
        val birthDayPrefix = "birthDay "
        val nationalityPrefix = "nationality "

        for (i in 0 until 1000) {
            val user = User(
                firstName = "$firstNamePrefix$i",
                lastName = "$lastNamePrefix$i",
                birthday = "$birthDayPrefix$i",
                nationality = "$nationalityPrefix$i"
            )
            users.add(
                user
            )

        }
        return users.toList()
    }

    fun getList(key: Int): List<User> {
        return users.subList(10 * key, 10 * key + 20)
    }
}