package com.example.cookit.api

import com.example.cookit.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MealApiService {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val callable by lazy {
        retrofit.create(MealApiCallable::class.java)
    }
}