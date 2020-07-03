package com.grandefirano.spaceforlove.data.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NasaPhotoOfTheDay(
    @Expose
    val date: String,
    @Expose
    val explanation: String,
    @SerializedName("media_type")
    val mediaType: String?,
    @Expose
    val title: String,
    @Expose
    val url: String,
    @Expose
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @Expose
    var liked:Boolean?
){



}