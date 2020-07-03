package com.grandefirano.spaceforlove.ui.matchingResult

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grandefirano.spaceforlove.AuthRepository
import com.grandefirano.spaceforlove.DatabaseRepository
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay
import com.grandefirano.spaceforlove.data.entity.SetOfTheMonth
import com.grandefirano.spaceforlove.network.NasaPhotoOfTheDayResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MatchingResultViewModel @ViewModelInject constructor(
    val databaseRepository: DatabaseRepository,
    val authRepository: AuthRepository) : ViewModel() {

    private val TAG = "MatchingResultViewModel"

    var likes=0
    var dislikes=0

    var photos= listOf<NasaPhotoOfTheDay>()


    fun saveSwipedPhotosToFirebase(){

        val setOfTheMonth=SetOfTheMonth(photos,"2020-06")

        CoroutineScope(viewModelScope.coroutineContext).launch {
            val result=databaseRepository.saveSwipedPhotosToFirebase(authRepository.getUserUId(),setOfTheMonth)
            Log.d(TAG, "saveSwipedPhotosToFirebase: result $result")
        }

    }


}