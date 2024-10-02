package com.example.cookit.api

import com.example.cookit.constants.Constants
import com.example.cookit.model.CategoryRoot
import com.example.cookit.model.MealRoot
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiCallable {
    @GET(Constants.CATEGORIES_ENDPOINT)
    suspend fun getCategories(): CategoryRoot

    @GET(Constants.FILTER_ENDPOINT)
    suspend fun getMeal(@Query(Constants.CATEGORY_QUERY) category :String): MealRoot

    @GET(Constants.LOOKUP_ENDPOINT)
    suspend fun getRecipe(@Query(Constants.INGREDIENT_QUERY) id :String): MealRoot
}