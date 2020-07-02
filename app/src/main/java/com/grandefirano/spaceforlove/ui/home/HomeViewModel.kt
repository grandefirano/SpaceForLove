package com.grandefirano.spaceforlove.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grandefirano.spaceforlove.AuthRepository
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(val authRepository: AuthRepository)
    : ViewModel() {




    fun logOut() {
        authRepository.logOut()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }


}