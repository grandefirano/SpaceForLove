package com.grandefirano.spaceforlove

import com.grandefirano.spaceforlove.network.NasaPhotoApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface Repository {

    suspend fun  fetchNasaPhotoOfTheDay():NasaPhotoOfTheDayResponse
}