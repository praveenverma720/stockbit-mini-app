package com.didik.core.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LiveData<T>.observeData(
    lifecycleOwner: LifecycleOwner,
    callback: (T) -> Unit
) {
    this.observe(lifecycleOwner, {
        it?.let { value ->
            callback.invoke(value)
        }
    })
}