package com.grandefirano.spaceforlove.di

import com.grandefirano.spaceforlove.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class ViewModelsModule {

    //change these Binds
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl):Repository

    @Binds
    abstract fun bindsAuthRepository(authRepositoryImpl: AuthRepositoryImpl):AuthRepository

    @Binds
    abstract fun bindsDatavaseRepository(databaseRepositoryImpl: DatabaseRepositoryImpl):DatabaseRepository
}