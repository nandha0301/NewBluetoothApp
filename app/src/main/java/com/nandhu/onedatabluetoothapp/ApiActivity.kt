package com.nandhu.onedatabluetoothapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nandhu.onedatabluetoothapp.Adapter.CountryListAdapter
import com.nandhu.onedatabluetoothapp.ViewModel.MainActivityViewModel

class ApiActivity : AppCompatActivity() {
    lateinit var recyclerview : RecyclerView
    lateinit var countryListAdapter: CountryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        recyclerview = findViewById(R.id.recycerview_list)

        initRecyclerview()

        initviewModel()
    }
    private fun initRecyclerview() {
        recyclerview.layoutManager = LinearLayoutManager(this)

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun initviewModel() {
        val viewmodel : MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewmodel.getLiveDataObserver().observe(this, Observer {

            if (it != null){
                countryListAdapter = CountryListAdapter(this,it)
                recyclerview.adapter = countryListAdapter
                countryListAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
        })
        viewmodel.makeapicall()
    }







}
