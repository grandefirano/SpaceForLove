package com.grandefirano.spaceforlove

import android.accounts.Account
import com.google.firebase.auth.FirebaseAuth

interface AuthRepository {
    val firebaseAuth: FirebaseAuth

    fun loginWithPasswordIntoFirebase(email: String, password: String)
    fun registerWithPasswordIntoFirebase(email: String, password: String)
    //TODO:change for this later
    fun registerIntoFirebase(account: Account)
    fun loginWithFacebookIntoFirebase()
    fun loginWithTwitterIntoFirebase()
}