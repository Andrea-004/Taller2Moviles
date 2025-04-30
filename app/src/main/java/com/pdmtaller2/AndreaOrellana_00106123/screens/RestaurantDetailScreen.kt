package com.pdmtaller2.AndreaOrellana_00106123.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2.AndreaOrellana_00106123.model.DataSample
import com.pdmtaller2.AndreaOrellana_00106123.model.Restaurant
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreen(restaurantId: Int?, navController: NavController) {
    val restaurant: Restaurant? = DataSample.restaurants.find { it.id == restaurantId }
    val context = LocalContext.current
    var searchText by remember { mutableStateOf("") }

    restaurant?.let {
        val filteredMenu = it.menu.filter { dish ->
            dish.name.contains(searchText, ignoreCase = true)
        }

        Scaffold(
            containerColor = Color(0xFFEEDDCB),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = it.name,
                            color = Color(0xFFA1866F),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Volver",
                                tint = Color(0xFFA1866F)
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Image(
                        painter = rememberAsyncImagePainter(it.imageUrl),
                        contentDescription = it.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it.description,
                        fontSize = 18.sp,
                        color = Color(0xFFA1866F),
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        label = {
                            Text(
                                text = "Buscar platillo",
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
                            .padding(bottom = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Menú",
                        fontSize = 20.sp,
                        color = Color(0xFFA1866F),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                items(filteredMenu) { dish ->
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFF0E6)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Image(
                                painter = rememberAsyncImagePainter(dish.imageUrl),
                                contentDescription = dish.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = dish.name,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFFA1866F)
                            )
                            Text(
                                text = dish.description,
                                fontSize = 14.sp,
                                color = Color(0xFFA1866F),
                            )
                            Spacer(modifier = Modifier.height(12.dp))

                            Button(
                                onClick = {
                                    Toast.makeText(context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                                },
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFF7CAC9),
                                    contentColor = Color.White
                                ),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text ="Agregar al carrito",
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }
        }
    } ?: run {
        Text(text = "Restaurante no encontrado", modifier = Modifier.padding(16.dp))
    }
}

