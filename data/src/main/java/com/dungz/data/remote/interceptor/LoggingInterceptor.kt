package com.dungz.data.remote.interceptor

import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Logging interceptor for OkHttp requests/responses.
 * TODO: Configure logging level based on build variant (debug/release)
 */
@Singleton
class LoggingInterceptor @Inject constructor() {
    fun create(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            // TODO: Set level based on BuildConfig.DEBUG
            // level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}
