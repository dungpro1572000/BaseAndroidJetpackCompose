package com.dungz.data.remote.api

import com.dungz.data.remote.dto.ExampleDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Base API service interface for Retrofit.
 * TODO: Replace with your actual API endpoints
 */
interface ApiService {
    // Example endpoints - TODO: Replace with your actual endpoints
    @GET("examples")
    suspend fun getExamples(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<List<ExampleDto>>

    @GET("examples/{id}")
    suspend fun getExampleById(@Path("id") id: Long): Response<ExampleDto>
}
