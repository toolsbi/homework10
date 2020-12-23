package com.example.homework10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewManager
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    lateinit var  viewModel:CityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application)).get(CityViewModel::class.java)
        viewModel.cities.observe(this, Observer {
            val cities=it
            val adapter = ArrayAdapter<City>(this, android.R.layout.simple_list_item_1, cities)
            listView.adapter = adapter
            listView.setOnItemClickListener { _, _, position, _ ->
                val cityCode = cities[position].city_code
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("city_code", cityCode)
                startActivity(intent)
            }

        })

    }
}

