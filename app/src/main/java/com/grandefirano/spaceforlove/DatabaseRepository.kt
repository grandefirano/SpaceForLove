package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.data.entity.MapOfReviews

interface DatabaseRepository {

    suspend fun saveSwipedPhotosToFirebase(userUId:String, mapOfReviews: MapOfReviews):Boolean
    suspend fun getSwipedPhotosFromFirebase()
}