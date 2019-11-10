package com.nb.retrofitx.network

import com.nb.retrofitx.models.RequestModel
import com.nb.retrofitx.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiInterface {

    @GET("bhoominn")
    suspend fun getUser(): Response<UserResponse>

    @GET("create-user")
    suspend fun createUser(@Body request: RequestModel): Response<UserResponse>

}