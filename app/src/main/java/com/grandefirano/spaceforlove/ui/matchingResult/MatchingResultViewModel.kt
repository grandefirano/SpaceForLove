package com.grandefirano.spaceforlove.ui.matchingResult

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grandefirano.spaceforlove.AuthRepository
import com.grandefirano.spaceforlove.DatabaseRepository
import com.grandefirano.spaceforlove.data.entity.ReviewOfPhotos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MatchingResultViewModel @ViewModelInject constructor(
    val databaseRepository: DatabaseRepository,
    val authRepository: AuthRepository) : ViewModel() {

    private val TAG = "MatchingResultViewModel"

    var likes=0
    var dislikes=0

    lateinit var reviewOfPhotos: ReviewOfPhotos


    fun saveSwipedPhotosToFirebase(){


        CoroutineScope(viewModelScope.coroutineContext).launch {
            val result=databaseRepository.saveSwipedPhotosToFirebase(authRepository.getUserUId(),reviewOfPhotos)
            Log.d(TAG, "saveSwipedPhotosToFirebase: result $result")
        }

    }


}