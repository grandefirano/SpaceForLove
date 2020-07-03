package com.grandefirano.spaceforlove

import android.accounts.Account
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val firebaseAuth: FirebaseAuth

    val state: LiveData<AuthenticationState>

    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED  ,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }



    fun logOut()
    fun loginWithPasswordIntoFirebase(email: String, password: String)
    fun registerWithPasswordIntoFirebase(email: String, password: String)
    //TODO:change for this later
    fun registerIntoFirebase(account: Account)
    fun loginWithFacebookIntoFirebase()
    fun loginWithTwitterIntoFirebase()

    fun getUserUId():String
}
