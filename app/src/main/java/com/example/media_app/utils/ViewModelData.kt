package com.example.media_app.utils

data class ViewModelData<V, E : Exception, P>(val data: V? = null, val error: E? = null, val progress: P? = null) {

    companion object {
        fun <V, E : Exception, P> error(error: E) = ViewModelData<V, E, P>(null, error, null)
        fun <V, E : Exception, P> progress(progress: P) = ViewModelData<V, E, P>(null, null, progress)
    }
}