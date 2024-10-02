package com.example.cookit.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookit.api.MealApiService
import com.example.cookit.model.Category
import com.example.cookit.model.CategoryRoot
import com.example.cookit.model.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Callback

class CategoryViewModel : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories = _categories.asStateFlow()

    private val _hasError = MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()

    init {
        getCategories()
    }
    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _categories.update {
                    MealApiService.callable.getCategories().categories
                }
                _hasError.update { false }
            }
            catch (e: Exception) {
                Log.d("trace", "C Error : ${e.message}")
                _hasError.update { true }
            }
        }
    }


    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meals = _meals.asStateFlow()

     fun getMeals(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _meals.update {
                    MealApiService.callable.getMeal(category).meals
                }
                _hasError.update { false }
            }
            catch (e: Exception) {
                Log.d("trace", "M Error : ${e.message}")
                _hasError.update { true }
            }
        }
    }


}