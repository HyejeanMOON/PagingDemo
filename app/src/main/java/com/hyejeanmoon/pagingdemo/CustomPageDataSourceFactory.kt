package com.hyejeanmoon.pagingdemo

import androidx.paging.DataSource

class CustomPageDataSourceFactory() : DataSource.Factory<Int, User>() {
    override fun create(): DataSource<Int, User> {
        return UsersDataSource()
    }
}