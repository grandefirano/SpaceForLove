package com.grandefirano.spaceforlove

import android.accounts.Account
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    override val firebaseAuth:FirebaseAuth)
    : AuthRepository {

    private val TAG = "AuthRepositoryImpl"

    override fun loginWithPasswordIntoFirebase(email: String, password: String){
        if(email.isNotBlank() && password.isNotBlank()){
            firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{task->
                    if(task.isSuccessful){
                        //TODO: go to MainPage
                        Log.d(TAG, "loginWithPasswordIntoFirebase: success")
                    }else{
                        //TODO:show error
                    }

                }
        }

    }

    override fun registerWithPasswordIntoFirebase(email: String, password: String) {
        if(email.isNotBlank()&&password.isNotBlank()) {
            val confirmPassword=password
            if(checkPassword(password,confirmPassword)) {
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "registerWithPasswordIntoFirebase: registered succesfully")
                        } else {
                            Log.d(TAG, "registerWithPasswordIntoFirebase: error while registering")
                        }
                    }
            }
        }else{
            //sth is blank
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
}