package com.grandefirano.spaceforlove.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay


//TODO:LATER (after firebase)

@Database(entities = [NasaPhotoOfTheDay::class],
    version = 1)
abstract class SpaceDatabase: RoomDatabase() {


}