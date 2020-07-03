package com.grandefirano.spaceforlove.network


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class NasaPhotoOfTheDayResponse(

    val date: String,

    val explanation: String,
    @SerializedName("media_type")
    val mediaType: String,

    val title: String,

    val url: String,
    val liked:Boolean?
)