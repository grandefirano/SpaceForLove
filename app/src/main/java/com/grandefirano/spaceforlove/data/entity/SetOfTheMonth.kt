package com.grandefirano.spaceforlove.data.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity

data class SetOfTheMonth(
    val photos:List<NasaPhotoOfTheDay>?,
    val date:String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(NasaPhotoOfTheDay),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(photos)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SetOfTheMonth> {
        override fun createFromParcel(parcel: Parcel): SetOfTheMonth {
            return SetOfTheMonth(parcel)
        }

        override fun newArray(size: Int): Array<SetOfTheMonth?> {
            return arrayOfNulls(size)
        }
    }
}