package com.dungz.myapplication.di

import com.dungz.data.mapper.ExampleMapper
import com.dungz.data.repository.ExampleRepositoryImpl
import com.dungz.domain.repository.ExampleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Data module for providing repository implementations and mappers.
 * TODO: Add more repository bindings here
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindExampleRepository(
        exampleRepositoryImpl: ExampleRepositoryImpl
    ): ExampleRepository

    // TODO: Add more repository bindings here
}

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideExampleMapper(): ExampleMapper = ExampleMapper()

    // TODO: Add more mappers here
}
