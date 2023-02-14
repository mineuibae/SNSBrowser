package com.example.snsbrowser.data.youtube.datasource.remote.retrofit

import com.example.snsbrowser.data.youtube.BuildConfig
import com.example.snsbrowser.data.youtube.datasource.remote.response.YoutubeSearchListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("search")
    suspend fun search(
        @Query("part") part: String,
        @Query("pageToken") pageToken: String?,
        @Query("q") q: String,
        @Query("type") type: String,
        @Query("maxResults") maxResults: Int,
        @Query("key") key: String = BuildConfig.API_KEY
    ): YoutubeSearchListResponse
}