package com.grandefirano.spaceforlove

import android.accounts.Account
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val firebaseAuth: FirebaseAuth

    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED  ,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }



    fun logOut()
    suspend fun loginWithPasswordIntoFirebase(email: String, password: String):AuthResult?
    suspend fun registerWithPasswordIntoFirebase(email: String, password: String):AuthResult?
    //TODO:change for this later
    fun registerIntoFirebase(account: Account)
    fun loginWithFacebookIntoFirebase()
    fun loginWithTwitterIntoFirebase()

    fun getUserUId():String
}
