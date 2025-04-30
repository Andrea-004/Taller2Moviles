package com.pdmtaller2.AndreaOrellana_00106123.screens

import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pdmtaller2.AndreaOrellana_00106123.components.RestaurantStructure
import com.pdmtaller2.AndreaOrellana_00106123.model.DataSample

@Composable
fun SearchScreen(navController: NavController) {
    var query by remember { mutableStateOf("") }
    val allRestaurants = DataSample.restaurants

    val filteredRestaurants = allRestaurants.filter { restaurant ->
        val matchesName = restaurant.name.contains(query, ignoreCase = true)
        val matchesCategory = restaurant.categories.any { it.contains(query, ignoreCase = true) }
        val matchesDish = restaurant.menu.any { it.name.contains(query, ignoreCase = true) }
        matchesName || matchesCategory || matchesDish
    }

    Scaffold(
        containerColor = Color(0xFFEEDDCB),
        topBar = {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = {
                    Text(
                        text = "Buscar por platillo, restaurante o categoría",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFA1866F)
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    cursorColor = Color(0xFFA1866F),
                    focusedBorderColor = Color(0xFFA1866F),
                    unfocusedBorderColor = Color(0xFFD7BFAE)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (filteredRestaurants.isEmpty()) {
                    Text("No hay resultados")
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(filteredRestaurants) { restaurant ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            ) {
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
        }
    )
}
