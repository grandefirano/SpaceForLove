package com.grandefirano.spaceforlove.ui.login

import android.util.Log
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.grandefirano.spaceforlove.AuthRepository
import com.grandefirano.spaceforlove.R
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor(val authRepository:AuthRepository)
    : ViewModel() {

    private val TAG = "LoginViewModel"

    fun loginWithPassword(view:View){
        viewModelScope.launch {
            val authResult=authRepository.loginWithPasswordIntoFirebase("ddd@gmail.com", "123456")
            Log.d(TAG, "loginWithPassword: ${authResult?.user?.email ?: "nope"}")

        }
    }

    fun goToRegister(view:View){
        view.findNavController().navigate(R.id.signUpFirebaseAuthFragment)
    }










}