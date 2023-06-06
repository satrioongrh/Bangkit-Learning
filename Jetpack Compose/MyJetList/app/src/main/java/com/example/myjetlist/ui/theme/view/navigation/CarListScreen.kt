package com.example.myjetlist.ui.theme.view.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myjetlist.model.CarsData
import com.example.myjetlist.ui.theme.view.CarListItem

@Composable
fun CarListScreen(navController: NavHostController) {
    val cars = remember { CarsData.cars }

    LazyColumn {
        items(cars, key = { it.id }) { car ->
            CarListItem(
                car = car,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate("${Screen.Detail.route}/${car.id}")
                }
            )
        }
    }
}