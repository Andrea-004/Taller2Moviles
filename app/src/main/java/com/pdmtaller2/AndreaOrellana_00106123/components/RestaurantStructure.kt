package com.pdmtaller2.AndreaOrellana_00106123.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2.AndreaOrellana_00106123.model.Restaurant

@Composable
fun RestaurantStructure(
    restaurant: Restaurant,
    onClick: () -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF)
        ),
        modifier = Modifier
            .width(220.dp)
            .clickable { onClick() }
            .padding(4.dp)
            .shadow(6.dp, RoundedCornerShape(20.dp))
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(restaurant.imageUrl),
                contentDescription = restaurant.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )
            Text(
                text = restaurant.name,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFA1866F),
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)
            )
        }
    }
}
