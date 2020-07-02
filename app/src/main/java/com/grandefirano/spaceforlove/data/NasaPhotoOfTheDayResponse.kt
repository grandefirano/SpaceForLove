package com.grandefirano.spaceforlove.data


import com.google.gson.annotations.SerializedName

data class NasaPhotoOfTheDayResponse(
    val date: String,
    val explanation: String,
    val hdurl: String,

    //TODO: check media_type!!!!
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val serviceVersion: String,
    val title: String,
    val url: String
)