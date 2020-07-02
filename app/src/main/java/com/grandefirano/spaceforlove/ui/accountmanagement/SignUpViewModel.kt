package com.grandefirano.spaceforlove.ui.accountmanagement

import android.util.Log
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.grandefirano.spaceforlove.AuthRepository
import com.grandefirano.spaceforlove.R
import javax.inject.Inject

class SignUpViewModel @ViewModelInject constructor(val authRepository: AuthRepository)
    : ViewModel() {
    private val TAG = "SignUpViewModel"

    fun registerWithPassword(view:View){
        authRepository.registerWithPasswordIntoFirebase("asd@gmail.com","123456")

    }

    fun goToLogin(view: View){
        Log.d(TAG, "goToLogin: Back")
        view.findNavController().navigateUp()
    }

}