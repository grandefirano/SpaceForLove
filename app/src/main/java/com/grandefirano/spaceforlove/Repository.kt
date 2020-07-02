package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.data.NasaPhotoOfTheDayResponse

interface Repository {

    suspend fun fetchNasaPhotoOfTheDay(date:String): NasaPhotoOfTheDayResponse

}