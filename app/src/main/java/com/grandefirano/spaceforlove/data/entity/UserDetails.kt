package com.grandefirano.spaceforlove.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDetails(
    val city:String?,
    val address:String?,
    val hasCoronavirus:Boolean?,
    val dateOfBirth:Long?,
    val phoneNumber:String?,
    val description:String?,
    val sex:String?,
    val interestedIn:String?,
    val smokeCigarettes:Boolean?,
    val likeSushi:Boolean?,
    val favouriteTypeOfSushi:String?,
    val exceedSpeedLimit:String?
):Parcelable