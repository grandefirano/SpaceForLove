package com.grandefirano.spaceforlove.ui.photoMatcher

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay
import com.grandefirano.spaceforlove.Repository

class PhotoMatcherViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    private val TAG = "PhotoMatcherViewModel"

    init {
        Log.d(TAG, "INIt: ")
    }
    

    var likes=0
    var dislikes=0

    fun addDislike() {
        dislikes++
    }
    fun addLike(){
       likes++
    }

    fun saveStateOfLikesAndDislikes(){

    }



    val nasaPhotos:LiveData<List<NasaPhotoOfTheDay>> = liveData {
        val list= mutableListOf<NasaPhotoOfTheDay>()
        for(i in 1..4) {
           list.add(repository.fetchNasaPhotoOfTheDay("2020-06-2$i"))
        }
        emit(list as List<NasaPhotoOfTheDay>)
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