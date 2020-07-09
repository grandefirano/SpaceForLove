package com.grandefirano.spaceforlove

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.grandefirano.spaceforlove.data.entity.ReviewOfPhotos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseRepositoryImpl @Inject constructor(
    val firebaseFirestore: FirebaseFirestore
) : DatabaseRepository {

    private val TAG = "DatabaseRepositoryImpl"

    override suspend fun saveReviewOfPhotosToFirebase(
        userUId: String,
        reviewOfPhotos: ReviewOfPhotos,
        date:String
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
                    .collection(date)
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

    override suspend fun getMatchingReviewsFromFirebase(userUId: String,
                                                        myReviewOfPhotos: ReviewOfPhotos,
                                                        date:String): DocumentSnapshot? {

        try{



            val result=firebaseFirestore
                .collection("reviews")
                .document("reviewsByDate")
                .collection(date)
                .get()
                .await()


       result.documents.forEach {
           it.toObject(ReviewOfPhotos::class.java)?.let {review->
               Log.d(TAG, "getMatchingReviewsFromFirebase: review ${review}")
               Log.d(TAG, "getMatchingReviewsFromFirebase: review ${review}")
               val myPhotos = myReviewOfPhotos.photos
               val photos = review.photos

               val percentage=comparePhotos(myPhotos,photos)
               if(percentage==100)sendNotification(it.id)

               Log.d(TAG, "getMatchingReviewsFromFirebase: percentage $percentage")

           }

       }

       }catch (e:Exception){
            println(e)
        }
    return null
    }

    override suspend fun getReviewFromFirebase(date:String,uId:String): ReviewOfPhotos? {
        return try {
            val document = firebaseFirestore
                .collection("reviews")
                .document("reviewsByDate")
                .collection("2020-06")
                .document(uId)
                .get()
                .await()

            document.toObject(ReviewOfPhotos::class.java)
        }catch (e:Exception){
            null
        }
    }

    private fun sendNotification(id:String){
        //TODO:send notification with Firebase Cloud Messaging
        //*store users tokens to send notification to exact user
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
        val percentage=(matchingCount*100)/myPhotos.size
        return percentage
    }


}


