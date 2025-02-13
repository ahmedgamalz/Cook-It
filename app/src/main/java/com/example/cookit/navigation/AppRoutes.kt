package com.example.cookit.navigation

import CategoryScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cookit.constants.Constants.MEAL_ID
import com.example.cookit.navigation.AppRoutes.CATEGORY_ROUTE
import com.example.cookit.navigation.AppRoutes.RECIPE_ROUTE
import com.example.cookit.ui.screens.RecipeScreen

object AppRoutes {
    const val CATEGORY_ROUTE = "category"
    const val RECIPE_ROUTE = "recipe"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CATEGORY_ROUTE, modifier = modifier) {
        composable(route = CATEGORY_ROUTE) { CategoryScreen(navController) }
        composable(
            route = "$RECIPE_ROUTE/{$MEAL_ID}",
            arguments = listOf(navArgument(MEAL_ID) { type = NavType.StringType })
        ) {
            val mealId = it.arguments?.getString(MEAL_ID)!!
            RecipeScreen(mealId, modifier)
        }
    }

}