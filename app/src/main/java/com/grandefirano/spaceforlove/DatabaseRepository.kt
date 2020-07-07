package com.grandefirano.spaceforlove

import com.google.firebase.firestore.DocumentSnapshot
import com.grandefirano.spaceforlove.data.entity.ReviewOfPhotos

interface DatabaseRepository {

    suspend fun saveReviewOfPhotosToFirebase(userUId:String, reviewOfPhotos: ReviewOfPhotos):Boolean
    suspend fun getMatchingReviewsFromFirebase(date:String,myReviewOfPhotos: ReviewOfPhotos):DocumentSnapshot?
    suspend fun getReviewFromFirebase(date:String,uId:String): ReviewOfPhotos?
}