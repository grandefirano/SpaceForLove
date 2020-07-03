package com.grandefirano.spaceforlove

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.grandefirano.spaceforlove.data.entity.MapOfReviews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.merge
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
        mapOfReviews: MapOfReviews
    ): Boolean {

        return withContext(Dispatchers.IO) {
            Log.d(TAG, "saveSwipedPhotosToFirebase: user id $userUId and map first ${mapOfReviews.photos.keys} ")
            //TODO:create when doesnt exist document /check
            /*...
             val ref = firebaseFirestore
                   .collection("reviews")
                    .document("date202006")
                    .set(mapOfReviews,SetOptions.mergeFields())
                    .await()
             */
            try {

                val ref = firebaseFirestore
                    .collection("reviews")
                    .document("2020-06")
                    .update(userUId,mapOfReviews)
                    .await()
                Log.d(TAG, "saveSwipedPhotosToFirebase:try after await ")
                true
            } catch (e: Exception) {
                Log.d(TAG, "saveSwipedPhotosToFirebase: catch $e")
                false
            }
        }
    }
    override suspend fun getSwipedPhotosFromFirebase() {
        TODO("Not yet implemented")
    }
}

