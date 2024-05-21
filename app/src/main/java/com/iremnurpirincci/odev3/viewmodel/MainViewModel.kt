package com.iremnurpirincci.odev3.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iremnurpirincci.odev3.model.urun
import com.iremnurpirincci.odev3.service.UrunAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {

    private val urunAPI = UrunAPIService()

    val urunData = MutableLiveData<List<urun>>()
    val urunLoad = MutableLiveData<Boolean>()
    val urunError = MutableLiveData<Boolean>()

   fun getDataFromAPI(){
       urunLoad.value = true

       urunAPI.getData().enqueue(object: Callback<List<urun>>{
           override fun onResponse(call: Call<List<urun>>, response: Response<List<urun>>) {
              urunData.value = response.body()
              urunLoad.value = false
               urunError.value = false
           }

           override fun onFailure(call: Call<List<urun>>, t: Throwable) {
               urunLoad.value = false
               urunError.value = true
               Log.e("RetrofitError",t.message.toString())
           }

       })
   }



}