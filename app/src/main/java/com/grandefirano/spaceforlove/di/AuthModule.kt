package com.grandefirano.spaceforlove.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

//TODO:change scope later
@InstallIn(ApplicationComponent::class)
@Module
class AuthModule {

    @Provides
    fun providesFirebaseAuth():FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

}