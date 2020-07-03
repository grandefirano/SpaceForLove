package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay

interface Repository {

    suspend fun fetchNasaPhotoOfTheDay(date:String): NasaPhotoOfTheDay

}