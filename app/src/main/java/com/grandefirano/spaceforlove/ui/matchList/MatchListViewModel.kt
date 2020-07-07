package com.grandefirano.spaceforlove.ui.matchList

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grandefirano.spaceforlove.AuthRepository
import com.grandefirano.spaceforlove.DatabaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MatchListViewModel  @ViewModelInject constructor(
    val databaseRepository: DatabaseRepository,
    val authRepository: AuthRepository
) : ViewModel() {

    private val userUid
    get() = authRepository.getUserUId()

    private val TAG = "MatchListViewModel"

    fun reloadListOfMatches(){
        CoroutineScope(viewModelScope.coroutineContext).launch {
            val myResult=databaseRepository.getReviewFromFirebase("2020-06",userUid)
            myResult?.let {myResult->
                val result = databaseRepository.getMatchingReviewsFromFirebase("2020-06", myResult)
                Log.d(TAG, "findMatches: result $result")
            }
        }
    }


}