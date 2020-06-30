package com.grandefirano.spaceforlove.ui.photoMatcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grandefirano.spaceforlove.NasaPhotoOfTheDayResponse
import com.grandefirano.spaceforlove.network.NasaPhotoApiService
import com.grandefirano.spaceforlove.util.lazyDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoMatcherViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        /*
        TODO: change for a picture
         */



        GlobalScope.launch {
        postValue(fetchPhoto().await().explanation)
            }
        /*

         */

    }
    val text: LiveData<String> = _text

    suspend fun  fetchPhoto() = withContext(Dispatchers.IO) {
            val nasa = NasaPhotoApiService.invoke()
            return@withContext nasa.getPhotoOfTheDay()


    }


}