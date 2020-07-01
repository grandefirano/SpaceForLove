package com.grandefirano.spaceforlove.ui.photoMatcher

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.grandefirano.spaceforlove.NasaPhotoOfTheDayResponse
import com.grandefirano.spaceforlove.Repository
import com.grandefirano.spaceforlove.RepositoryImpl
import com.grandefirano.spaceforlove.network.NasaPhotoApiService
import com.grandefirano.spaceforlove.util.lazyDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhotoMatcherViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {


    init {

        viewModelScope.launch {

        }

    }


    val nasaPhotos:LiveData<NasaPhotoOfTheDayResponse> = liveData {
        val data=repository.fetchNasaPhotoOfTheDay()
        emit(data)
    }

//
//    private val _text = MutableLiveData<String>().apply {
//        /*
//        TODO: change for a picture
//         */
//
//
//
//        \
//
//    }
//    val text: LiveData<String> = _text



}