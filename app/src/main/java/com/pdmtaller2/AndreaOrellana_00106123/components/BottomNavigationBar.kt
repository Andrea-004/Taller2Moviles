package com.pdmtaller2.AndreaOrellana_00106123.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<BottomNavItem>
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color(0xFFFFF0E6)
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                label = {
                    Text(
                        text = item.title,
                        fontSize = 15.sp,
                        color = if (isSelected)
                            Color(0xFFA1866F)
                        else
                            Color(0xFFC8A69F)
                    )
                },
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.route) {
                            popUpTo("restaurantList") { inclusive = false }
                            launchSingleTop = true
                        }
                    }
                },
                icon = {},
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFFFE8E1)
                )
            )
        }
    }
}
