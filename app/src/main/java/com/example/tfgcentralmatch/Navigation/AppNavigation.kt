package com.example.tfgcentralmatch.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tfgcentralmatch.Screens.Inicio

@Composable
fun AppNavigaton() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PantallasApp.Inicio.ruta
    ){
        composable(PantallasApp.Inicio.ruta){ Inicio(navController) }
    }
}