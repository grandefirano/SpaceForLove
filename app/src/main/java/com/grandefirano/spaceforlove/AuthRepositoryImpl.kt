package com.grandefirano.spaceforlove

import android.accounts.Account
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.grandefirano.spaceforlove.AuthRepository.AuthenticationState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    override val firebaseAuth:FirebaseAuth
) : AuthRepository {


    private val TAG = "AuthRepositoryImpl"

    override suspend fun loginWithPasswordIntoFirebase(email: String, password: String): AuthResult? {
        return if(email.isNotBlank() && password.isNotBlank()) {

            withContext(Dispatchers.IO) {
                firebaseAuth.signInWithEmailAndPassword(email, password).await()
            }
        }else{
            null
        }

    }

    override suspend fun registerWithPasswordIntoFirebase(email: String, password: String):AuthResult?{
        return if(email.isNotBlank()&&password.isNotBlank()) {
            val confirmPassword=password
            if (checkPassword(password,confirmPassword)) {
                withContext(Dispatchers.IO) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).await()
                }
            } else{
                //passwords aren't the same
                null
            }
        }else{
            //sth is blank
            null
        }
    }
    //TODO:modify this
    private fun checkPassword(password: String,confirmPassword:String): Boolean {
        return if(password == confirmPassword && password.length>=5){
            true
        } else if (password == confirmPassword) {
            //passwords are not the same
            false
        } else if (password.length < 5) {
            //password is too short
            false
        } else false
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

    override fun getUserUId(): String {
       return firebaseAuth.currentUser!!.uid
    }


    override fun logOut() {
        firebaseAuth.signOut()
    }
}