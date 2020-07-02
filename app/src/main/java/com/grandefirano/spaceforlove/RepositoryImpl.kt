package com.grandefirano.spaceforlove

import android.accounts.Account
import com.grandefirano.spaceforlove.network.NasaPhotoApiService
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImpl @Inject constructor():Repository {

    override suspend fun  fetchNasaPhotoOfTheDay() = withContext(Dispatchers.IO) {
        val nasa = NasaPhotoApiService.invoke()
        //TODO:Nasa put also videos so this is temporary
        return@withContext nasa.getPhotoOfTheDay("2020-06-30")
    }



}