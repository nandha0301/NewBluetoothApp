package com.nandhu.onedatabluetoothapp.Apicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    val apiService : ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }

}
//https://restcountries.com/v2/all

object RetrofitClient{
    private const val BASE_URL = "https://restcountries.com/v2/"

    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}