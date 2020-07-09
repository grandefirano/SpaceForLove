package com.grandefirano.spaceforlove

import com.google.firebase.firestore.DocumentSnapshot
import com.grandefirano.spaceforlove.data.entity.ReviewOfPhotos

interface DatabaseRepository {

    suspend fun saveReviewOfPhotosToFirebase(userUId:String, reviewOfPhotos: ReviewOfPhotos,date:String):Boolean
    suspend fun getMatchingReviewsFromFirebase(userUId: String,myReviewOfPhotos: ReviewOfPhotos,date:String):DocumentSnapshot?
    suspend fun getReviewFromFirebase(date:String,uId:String): ReviewOfPhotos?
}