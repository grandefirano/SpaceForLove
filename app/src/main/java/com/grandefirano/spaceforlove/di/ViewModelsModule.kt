package com.grandefirano.spaceforlove.di

import com.grandefirano.spaceforlove.Repository
import com.grandefirano.spaceforlove.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class ViewModelsModule {

    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl):Repository
}