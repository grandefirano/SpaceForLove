package com.grandefirano.spaceforlove.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailsOfReview(
    val sex:String,
    val interestedIn:String) :Parcelable{

    constructor():this("","")
}