package com.grandefirano.spaceforlove

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel @ViewModelInject constructor(val authRepository: AuthRepository): ViewModel(){


    //get  task.await() and methods in viewmodel to set state from main activity

    private val _state= MutableLiveData<AuthRepository.AuthenticationState>()
    val state: LiveData<AuthRepository.AuthenticationState>
        get() = _state



    init {
        authRepository.firebaseAuth.apply {
            //listen for current user state and change Authentication state respectively
            addAuthStateListener {
                if(authRepository.firebaseAuth.currentUser==null){
                    _state.postValue(AuthRepository.AuthenticationState.UNAUTHENTICATED)
                }else{
                    _state.postValue(AuthRepository.AuthenticationState.AUTHENTICATED)
                }
            }
        }
    }
}