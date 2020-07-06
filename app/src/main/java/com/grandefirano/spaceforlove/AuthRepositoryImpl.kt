package com.grandefirano.spaceforlove

import android.accounts.Account
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.grandefirano.spaceforlove.AuthRepository.AuthenticationState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    override val firebaseAuth:FirebaseAuth

)
    : AuthRepository {

    //TODO:to main viewmodel?
    //get  task.await() and methods in viewmodel to set state from main activity

    val _state= MutableLiveData<AuthenticationState>()
    override val state: LiveData<AuthenticationState>
    get() = _state

    private val TAG = "AuthRepositoryImpl"


    init {
        firebaseAuth.apply {
            //listen for current user state and change Authentication state respectively
            addAuthStateListener {
                if(firebaseAuth.currentUser==null){
                    _state.postValue(AuthenticationState.UNAUTHENTICATED)
                }else{
                    _state.postValue(AuthenticationState.AUTHENTICATED)
                }
            }
        }
    }

    override fun loginWithPasswordIntoFirebase(email: String, password: String){
        if(email.isNotBlank() && password.isNotBlank()){
            firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{task->
                    if(task.isSuccessful){
                        _state.postValue(AuthenticationState.AUTHENTICATED)
                        Log.d(TAG, "loginWithPasswordIntoFirebase: success")
                    }else{
                        _state.postValue(AuthenticationState.UNAUTHENTICATED)
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

    override fun getUserUId(): String {
       return firebaseAuth.currentUser!!.uid
    }


    override fun logOut() {
        firebaseAuth.signOut()
    }
}