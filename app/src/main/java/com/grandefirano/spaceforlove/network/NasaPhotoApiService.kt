package com.grandefirano.spaceforlove.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface NasaPhotoApiService {

    @GET("planetary/apod")
    suspend fun getPhotoOfTheDay(
        @Query("date") date:String=""
    ): NasaPhotoOfTheDayResponse

    //? here or change to app
    companion object{
        operator fun invoke(
        ):NasaPhotoApiService{

            val requestInterceptor=Interceptor{chain ->

                val url=chain.request().url().newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()
                val request=chain.request().newBuilder()
                    .url(url).build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient=OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NasaPhotoApiService::class.java)
        }
    }

}