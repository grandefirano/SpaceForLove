package com.grandefirano.spaceforlove.ui.login

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.grandefirano.spaceforlove.AuthRepository
import com.grandefirano.spaceforlove.R
import javax.inject.Inject

class LoginViewModel @ViewModelInject constructor(val authRepository:AuthRepository)
    : ViewModel() {

    fun loginWithPassword(){
        authRepository.loginWithPasswordIntoFirebase("asd@gmail.com","123456")

    }

    fun goToRegister(view:View){
        view.findNavController().navigate(R.id.signUpFragment)
    }


}