package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.network.NasaPhotoOfTheDayResponse

interface Repository {

    suspend fun fetchNasaPhotoOfTheDay(date:String): NasaPhotoOfTheDayResponse

}