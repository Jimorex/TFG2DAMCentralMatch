package com.example.tfgcentralmatch.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tfgcentralmatch.Model.DatosViewModel
import com.example.tfgcentralmatch.Screens.Inicio
import com.example.tfgcentralmatch.Screens.PartidoNuevo
import com.example.tfgcentralmatch.Screens.PartidoSenior

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigaton() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PantallasApp.Inicio.ruta
    ){
        composable(PantallasApp.Inicio.ruta){ Inicio(navController) }
        composable(PantallasApp.PartidoNuevo.ruta){ PartidoNuevo(navController) }
        composable("SENIOR"){ PartidoSenior(viewModel = DatosViewModel(), navController) }
    }
}