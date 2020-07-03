package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay

interface DatabaseRepository {

    suspend fun saveSwipedPhotosToFirebase(userUId:String,listOfPhotos:List<NasaPhotoOfTheDay>):Boolean
    suspend fun getSwipedPhotosFromFirebase()
}