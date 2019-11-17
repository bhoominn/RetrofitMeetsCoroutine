package com.nb.retrofitx.network

import com.nb.retrofitx.models.RequestModel
import com.nb.retrofitx.models.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("bhoominn")
    suspend fun getUser(): Response<UserResponse>

    @GET("bhoominn")
    fun getUser1(): Call<UserResponse>

    @POST("create-user")
    suspend fun createUser(@Body request: RequestModel): Response<UserResponse>

    @POST("create-user")
    fun createNewUser(@Body request: RequestModel): Call<UserResponse>

}