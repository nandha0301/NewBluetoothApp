package com.nandhu.onedatabluetoothapp.Apicall

import com.nandhu.onedatabluetoothapp.Dataclass.CountryList
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    fun getCountryList() : Call<List<CountryList>>

}