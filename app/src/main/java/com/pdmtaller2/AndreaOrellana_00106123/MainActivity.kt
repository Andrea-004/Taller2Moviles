package com.pdmtaller2.AndreaOrellana_00106123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdmtaller2.AndreaOrellana_00106123.screens.RestaurantDetailScreen
import com.pdmtaller2.AndreaOrellana_00106123.components.BottomNavItem
import com.pdmtaller2.AndreaOrellana_00106123.components.BottomNavigationBar
import com.pdmtaller2.AndreaOrellana_00106123.screens.RestaurantsScreen
import com.pdmtaller2.AndreaOrellana_00106123.screens.SearchScreen
import com.pdmtaller2.AndreaOrellana_00106123.screens.MyOrdersScreen
import androidx.compose.material3.Scaffold


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val bottomNavItems = listOf(
        BottomNavItem("Restaurantes", "restaurantList"),
        BottomNavItem("Buscar", "search"),
        BottomNavItem("Órdenes", "orders")
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController, bottomNavItems)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "restaurantList",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("restaurantList") {
                RestaurantsScreen(navController)
            }
            composable("search") {
                SearchScreen(navController)
            }
            composable("orders") {
                MyOrdersScreen()
            }
            composable(
                "restaurantDetail/{restaurantId}",
                arguments = listOf(navArgument("restaurantId") { type = NavType.IntType })
            ) { backStackEntry ->
                val restaurantId = backStackEntry.arguments?.getInt("restaurantId")
                RestaurantDetailScreen(restaurantId, navController)
            }
        }
    }
}

