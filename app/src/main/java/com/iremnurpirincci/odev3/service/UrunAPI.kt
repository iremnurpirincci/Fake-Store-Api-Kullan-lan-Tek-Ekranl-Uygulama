package com.iremnurpirincci.odev3.service

import com.iremnurpirincci.odev3.model.urun
import retrofit2.Call
import retrofit2.http.GET

interface UrunAPI {
   // https://fakestoreapi.com/products

    @GET("products")
    fun geturunler() : Call<List<urun>>
}