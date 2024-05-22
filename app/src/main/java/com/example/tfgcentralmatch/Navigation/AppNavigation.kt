package com.example.tfgcentralmatch.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tfgcentralmatch.Screens.Inicio
import com.example.tfgcentralmatch.Screens.PartidoNuevo

@Composable
fun AppNavigaton() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PantallasApp.Inicio.ruta
    ){
        composable(PantallasApp.Inicio.ruta){ Inicio(navController) }
        composable(PantallasApp.PartidoNuevo.ruta){ PartidoNuevo(navController) }
    }
}