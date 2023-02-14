package com.example.snsbrowser.data.youtube.di

import com.example.snsbrowser.data.youtube.BuildConfig
import com.example.snsbrowser.data.youtube.datasource.remote.retrofit.YoutubeApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providesYoutubeApi(
        networkJson: Json,
        okHttpClient: OkHttpClient
    ) : YoutubeApi {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                networkJson.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(YoutubeApi::class.java)
    }
}