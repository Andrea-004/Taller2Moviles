package com.pdmtaller2.AndreaOrellana_00106123.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pdmtaller2.AndreaOrellana_00106123.model.DataSample
import com.pdmtaller2.AndreaOrellana_00106123.components.RestaurantStructure


@Composable
fun RestaurantsScreen(navController: NavController) {
    val restaurants = DataSample.restaurants
    val categories = restaurants.flatMap { it.categories }.distinct()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEDDCB))
            .padding(16.dp)
    ) {
        items(categories) { category ->
            Text(
                text = category,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA1866F),
                modifier = Modifier.padding(vertical = 12.dp)
            )
            val restaurantsForCategory = restaurants.filter { it.categories.contains(category) }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp)
                    .border(
                        width = 3.dp,
                        color = Color(0xFFA1866F),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp)
            ) {
                items(restaurantsForCategory) { restaurant ->
                    RestaurantStructure(
                        restaurant = restaurant,
                        onClick = {
                            navController.navigate("restaurantDetail/${restaurant.id}")
                        }
                    )
                }
            }
        }
    }
}
