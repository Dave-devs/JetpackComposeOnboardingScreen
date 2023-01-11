package com.example.jetpackcomposeonboardingscreen.feature_onboarding.di

import android.content.Context
import com.example.jetpackcomposeonboardingscreen.feature_onboarding.data.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context) = DataStoreRepository(context = context)

}