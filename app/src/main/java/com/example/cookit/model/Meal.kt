package com.example.cookit.model

import com.example.cookit.constants.Constants
import com.google.gson.annotations.SerializedName


class MealRoot(val meals : List<Meal>)
class Meal(

    @SerializedName(Constants.MEAL_NAME)
    val name :String = "",
    @SerializedName(Constants.MEAL_IMAGE)
    val image :String = "",
    @SerializedName(Constants.MEAL_ID)
    val id :String= "",
    @SerializedName(Constants.MEAL_INSTRUCTIONS)
    val instruction :String = "",
    @SerializedName(Constants.MEAL_VIDEO)
    val video :String = "",
)