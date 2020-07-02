package com.grandefirano.spaceforlove

import android.accounts.Account
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    override val firebaseAuth:FirebaseAuth)
    : AuthRepository {
    override fun loginWithPasswordIntoFirebase(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun registerIntoFirebase(account: Account) {
        TODO("Not yet implemented")
    }

    override fun loginWithFacebookIntoFirebase() {
        TODO("Not yet implemented")
    }

    override fun loginWithTwitterIntoFirebase() {
        TODO("Not yet implemented")
    }
}