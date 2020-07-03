package com.grandefirano.spaceforlove.data.entity


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class NasaPhotoOfTheDay(
    val date: String?,
    val title: String?,
    val url: String?,
    val liked:Boolean?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeValue(liked)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NasaPhotoOfTheDay> {
        override fun createFromParcel(parcel: Parcel): NasaPhotoOfTheDay {
            return NasaPhotoOfTheDay(parcel)
        }

        override fun newArray(size: Int): Array<NasaPhotoOfTheDay?> {
            return arrayOfNulls(size)
        }
    }
}