package com.nb.retrofitx.extensions

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class GlobalScopeExt<T>(context: T, coroutineScope:suspend CoroutineScope.() -> Unit = {}) : LifecycleObserver where T : Context, T : LifecycleOwner {
    var myJob: Job= Job()
    private val coroutineContext : CoroutineContext get() = myJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    init {
        context.lifecycle.addObserver(this)
        scope.launch {
            coroutineScope.invoke(scope)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop() = myJob.cancel()
}