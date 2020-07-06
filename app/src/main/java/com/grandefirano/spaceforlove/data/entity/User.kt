package com.grandefirano.spaceforlove.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val name:String,
    val photoUrl:String,
    val dateCreatedTimestamp:Long
):Parcelable