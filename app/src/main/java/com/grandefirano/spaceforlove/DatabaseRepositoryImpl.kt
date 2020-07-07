package com.grandefirano.spaceforlove

import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.grandefirano.spaceforlove.data.entity.ReviewOfPhotos
import com.grandefirano.spaceforlove.data.entity.ReviewsForDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseRepositoryImpl @Inject constructor(val firebaseFirestore: FirebaseFirestore) : DatabaseRepository {

    private val TAG = "DatabaseRepositoryImpl"

    override suspend fun saveReviewOfPhotosToFirebase(
        userUId: String,
        reviewOfPhotos: ReviewOfPhotos
    ): Boolean {

        return withContext(Dispatchers.IO) {
            Log.d(TAG, "saveSwipedPhotosToFirebase: user id $userUId and map first ${reviewOfPhotos.photos.keys} ")

            try {
                //changed from one to many documents because of limit of fields
                //30 photos per person & limit of 40 000 fields
                //with thousand of user there will be no more fields available to write
                //also 1 write per second per document can cause errors


                val ref = firebaseFirestore
                    .collection("reviews")
                    .document("reviewsByDate")
                    .collection("2020-06")
                    .document(userUId)
                    .set(reviewOfPhotos)
                    .await()
                Log.d(TAG, "saveSwipedPhotosToFirebase:try after await ")
                true
            } catch (e: Exception) {
                Log.d(TAG, "saveSwipedPhotosToFirebase: catch $e")
                false
            }
        }
    }

    override suspend fun getMatchingReviewsFromFirebase(date:String,myReviewOfPhotos: ReviewOfPhotos): DocumentSnapshot? {

        try{
            val result=firebaseFirestore
                .collection("reviews")
                .document("reviewsByDate")
                .collection("2020-06")
                .get()
                .await()
//
//            val document=firebaseFirestore
//                .collection("reviews")
//                .document("2020-06")
//                .get()
//                .await()
//



       result.documents.forEach {
           it.toObject(ReviewOfPhotos::class.java)?.let {review->
               Log.d(TAG, "getMatchingReviewsFromFirebase: review ${review}")
               Log.d(TAG, "getMatchingReviewsFromFirebase: review ${review}")
               val myPhotos = myReviewOfPhotos.photos
               val photos = review.photos

               val percentage=comparePhotos(myPhotos,photos)

               Log.d(TAG, "getMatchingReviewsFromFirebase: percentage $percentage")

           }

       }

       }catch (e:Exception){
            println(e)
        }
    return null
    }
    private fun comparePhotos(myPhotos:HashMap<String,Boolean>,theirPhotos:HashMap<String,Boolean>):Int{
       var matchingCount=0
        for((key,value) in myPhotos){
            Log.d(TAG, "getMatchingReviewsFromFirebase: key $key, value $value" +
                    "theirPhotos: ${theirPhotos[key]}")
            val ifff=value==theirPhotos[key]
            Log.d(TAG, "getMatchingReviewsFromFirebase: if $ifff")
            if(ifff){
                matchingCount++
            }
        }
        Log.d(TAG, "comparePhotos: matching count $matchingCount full list ${myPhotos.size}")
        val percentage=((matchingCount/myPhotos.size)*100)
        return percentage
    }


}


