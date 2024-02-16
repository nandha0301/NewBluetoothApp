package com.nandhu.onedatabluetoothapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nandhu.onedatabluetoothapp.Apicall.ApiClient
import com.nandhu.onedatabluetoothapp.Dataclass.CountryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel() {

    lateinit var liveData: MutableLiveData<List<CountryList>>


    init {
        liveData = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<List<CountryList>> {
        return liveData
    }

    fun makeapicall(){

        val call = ApiClient.apiService.getCountryList()

        call.enqueue(object : Callback<List<CountryList>> {
            override fun onResponse(call: Call<List<CountryList>>, response: Response<List<CountryList>>) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CountryList>>, t: Throwable) {
                liveData.postValue(null)
            }

        })



    }
}