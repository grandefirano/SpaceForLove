package com.grandefirano.spaceforlove.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay



//TODO:LATER (after firebase)
@Dao
interface NasaPhotosOfTheMonthDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(listOfPhotos:List<NasaPhotoOfTheDay>)



}