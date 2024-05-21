package com.iremnurpirincci.odev3.service

import com.iremnurpirincci.odev3.model.urun
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UrunAPIService {

    // https://fakestoreapi.com/products

    private val BASE_URL = "https://fakestoreapi.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UrunAPI::class.java)

    fun getData() : Call<List<urun>> {
        return api.geturunler()
    }
}