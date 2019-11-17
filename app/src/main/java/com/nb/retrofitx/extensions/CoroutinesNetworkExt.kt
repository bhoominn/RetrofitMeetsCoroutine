package com.nb.retrofitx.extensions

import android.util.Log
import com.google.gson.Gson
import com.nb.retrofitx.models.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T> getResponse(call: Response<T>, onApiSuccess: (T) -> Unit, onApiError: (message: String) -> Unit = {}) {
    val response = withContext(Dispatchers.IO) { call }
    Log.d("api_url", "${response.raw().request().url()}")
    if (response.raw().request().body() != null) Log.d("api_request", "${response.raw().request().body()}")

    if (response.isSuccessful) if (response.body()!! is BaseResponse) {
        if ((response.body()!! as BaseResponse).status) onApiSuccess(response.body()!!)
        else onApiError((response.body()!! as BaseResponse).message); Log.d("api_response", Gson().toJson(response.body()))
    } else {
        onApiError("Error"); Log.e("api_response", response.errorBody()?.toString()!!)
    } else {
        onApiError("Error"); Log.e("api_error", response.errorBody()?.toString()!!)
    }
}