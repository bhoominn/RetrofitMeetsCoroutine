package com.nb.retrofitx.network

import android.app.Activity
import android.util.Log
import com.nb.retrofitx.extensions.callApi
import com.nb.retrofitx.extensions.getApis
import com.nb.retrofitx.extensions.isNetworkAvailable
import com.nb.retrofitx.extensions.toast
import com.nb.retrofitx.models.UserResponse

suspend fun Activity.getUser(onApiSuccess: (UserResponse) -> Unit, onApiError: (String) -> Unit = {}, onNetworkError: () -> Unit = {}) {
    try {
        callApi(getApis().getUser(), { runOnUiThread { onApiSuccess(it) } }, { runOnUiThread { toast(it) }; onApiError(it) })
    } catch (e: Exception) {
        if (isNetworkAvailable()) Log.e("api_error", e.toString()) else runOnUiThread { toast("No internet") };onNetworkError()
    }
}