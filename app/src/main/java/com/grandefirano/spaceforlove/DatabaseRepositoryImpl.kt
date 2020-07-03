package com.grandefirano.spaceforlove

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay
import com.grandefirano.spaceforlove.data.entity.SetOfTheMonth
import com.grandefirano.spaceforlove.network.NasaPhotoOfTheDayResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseRepositoryImpl @Inject constructor(val firebaseFirestore: FirebaseFirestore) : DatabaseRepository {

    private val TAG = "DatabaseRepositoryImpl"

    override suspend fun saveSwipedPhotosToFirebase(
        userUId: String,
        setOfTheMonth: SetOfTheMonth
    ): Boolean {

        return withContext(Dispatchers.IO) {
            Log.d(TAG, "saveSwipedPhotosToFirebase: user id $userUId ")
            try {
                val data = firebaseFirestore
                    .collection("users")
                    .document(userUId)
                    .update("swiped_photos",setOfTheMonth)
                    .await()
                Log.d(TAG, "saveSwipedPhotosToFirebase:try after await ")
                true
            } catch (e: Exception) {
                Log.d(TAG, "saveSwipedPhotosToFirebase: catch ")
                false
            }
        }
    }
    override suspend fun getSwipedPhotosFromFirebase() {
        TODO("Not yet implemented")
    }
}


