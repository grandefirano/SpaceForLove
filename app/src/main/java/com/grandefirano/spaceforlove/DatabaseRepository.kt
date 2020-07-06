package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.data.entity.ReviewOfPhotos

interface DatabaseRepository {

    suspend fun saveSwipedPhotosToFirebase(userUId:String, reviewOfPhotos: ReviewOfPhotos):Boolean
    suspend fun getSwipedPhotosFromFirebase()
}