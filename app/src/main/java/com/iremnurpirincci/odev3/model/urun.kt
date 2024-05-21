package com.iremnurpirincci.odev3.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

//import android.graphics.drawable.Drawable

data class urun(
    @SerializedName("title")
    val title:String,
    @SerializedName("price")
    val price:Float,
    @SerializedName("image")
    val flagUrl: String
)
