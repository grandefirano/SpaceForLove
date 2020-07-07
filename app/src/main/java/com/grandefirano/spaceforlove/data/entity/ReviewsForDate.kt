package com.grandefirano.spaceforlove.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReviewsForDate(
    val mapOfReviewsForDate: HashMap<String,ReviewOfPhotos>
) : Parcelable{

    constructor():this(HashMap())
}