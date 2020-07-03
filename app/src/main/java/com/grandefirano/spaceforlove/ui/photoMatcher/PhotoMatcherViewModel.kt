package com.grandefirano.spaceforlove.ui.photoMatcher

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.grandefirano.spaceforlove.network.NasaPhotoOfTheDayResponse
import com.grandefirano.spaceforlove.Repository
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay

class PhotoMatcherViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    private val TAG = "PhotoMatcherViewModel"

    init {
        Log.d(TAG, "INIt: ")
    }
    

    var likes=0
    var dislikes=0

    val listOfPhotos= arrayListOf<NasaPhotoOfTheDay>()
    val mapOfReviews= hashMapOf<String,Boolean>()

    fun addDislike() {
        dislikes++
    }
    fun addLike(){
       likes++
    }

    fun saveStateOfLikesAndDislikes(){

    }




    val nasaPhotosResponse:LiveData<List<NasaPhotoOfTheDayResponse>> = liveData {
        val list= mutableListOf<NasaPhotoOfTheDayResponse>()
        for(i in 1..4) {
           list.add(repository.fetchNasaPhotoOfTheDay("2020-06-2$i"))
        }
        emit(list as List<NasaPhotoOfTheDayResponse>)
    }

    fun addPhotoToList(position:Int,liked:Boolean){
        nasaPhotosResponse.value!![position]?.let {
            mapOfReviews[it.date] = liked

//            listOfPhotos.add(NasaPhotoOfTheDay(
//                it.date,
//                liked))
        }

    }



}