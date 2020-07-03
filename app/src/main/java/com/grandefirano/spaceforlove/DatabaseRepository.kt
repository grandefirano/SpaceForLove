package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay
import com.grandefirano.spaceforlove.data.entity.SetOfTheMonth
import com.grandefirano.spaceforlove.network.NasaPhotoOfTheDayResponse

interface DatabaseRepository {

    suspend fun saveSwipedPhotosToFirebase(userUId:String, setOfTheMonth: SetOfTheMonth):Boolean
    suspend fun getSwipedPhotosFromFirebase()
}