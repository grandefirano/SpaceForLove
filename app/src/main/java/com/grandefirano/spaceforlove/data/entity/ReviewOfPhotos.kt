package com.grandefirano.spaceforlove.data.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReviewOfPhotos(
    val photos:HashMap<String,Boolean>,
    val sex:String,
    val interestedIn:String

) : Parcelable{
    constructor():this(HashMap(),"","")
}