package com.dicoding.mymoviecatalogue.data.source.local.remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            val logInter =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val myClient = OkHttpClient.Builder()
                .addInterceptor(logInter)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .client(myClient)
                .build()
            return retrofit.create(ApiService::class.java)

        }
    }
}