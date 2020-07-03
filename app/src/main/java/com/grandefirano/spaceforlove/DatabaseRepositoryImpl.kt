package com.grandefirano.spaceforlove

import com.google.firebase.firestore.FirebaseFirestore
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseRepositoryImpl @Inject constructor(val firebaseFirestore: FirebaseFirestore) : DatabaseRepository {
    override suspend fun saveSwipedPhotosToFirebase(
        userUId: String,
        listOfPhotos: List<NasaPhotoOfTheDay>
    ): Boolean {
        return try{
            val data=firebaseFirestore
                .collection("users")
                .document(userUId)
                .set(listOfPhotos)
                .await()
            true
        }catch (e:Exception){
            false
        }
    }


    override suspend fun getSwipedPhotosFromFirebase() {
        TODO("Not yet implemented")
    }
}