package com.jquiroga.data.datasource.remote.api.client

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jquiroga.data.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


private val CONTENT_TYPE_JSON = MediaType.get("application/json")

private const val BASE_URL = "https://itunes.apple.com/"

private const val CONNECTION_TIMEOUT: Long = 30L
private const val READ_TIMEOUT: Long = 30L
private const val WRITE_TIMEOUT: Long = 30L

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        })
        .build()
}

fun createRetrofit(): Retrofit {
    val json = Json { ignoreUnknownKeys = true }
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(CONTENT_TYPE_JSON))
        .client(createOkHttpClient())
        .build()
}

inline fun <reified T> provideApi(): T {
    return createRetrofit().create(T::class.java)
}



