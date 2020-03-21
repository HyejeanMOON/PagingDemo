package com.hyejeanmoon.pagingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hyejeanmoon.pagingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        val adapter = UsersAdapter()

        binding.recyclerView.adapter = adapter

        val data = LivePagedListBuilder(
            CustomPageDataSourceFactory(),
            PagedList.Config.Builder().setPageSize(20).setInitialLoadSizeHint(20).build()
        ).build()

        data.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
