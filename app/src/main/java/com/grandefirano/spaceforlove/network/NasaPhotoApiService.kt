package com.grandefirano.spaceforlove.network

import com.grandefirano.spaceforlove.NasaPhotoOfTheDayResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface NasaPhotoApiService {

    @GET("")
    fun getPhotoOfTheDay(
        @Query("date") date:String
    ):Deferred<NasaPhotoOfTheDayResponse>

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


            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NasaPhotoApiService::class.java)
        }
    }

}