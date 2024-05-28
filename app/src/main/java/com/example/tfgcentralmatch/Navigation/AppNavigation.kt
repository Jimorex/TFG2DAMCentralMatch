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
import com.example.tfgcentralmatch.Screens.PartidoS10
import com.example.tfgcentralmatch.Screens.PartidoS12
import com.example.tfgcentralmatch.Screens.PartidoS14S16VET
import com.example.tfgcentralmatch.Screens.PartidoS18
import com.example.tfgcentralmatch.Screens.PartidoS6
import com.example.tfgcentralmatch.Screens.PartidoS8
import com.example.tfgcentralmatch.Screens.PartidoSenior
import com.example.tfgcentralmatch.Screens.PartidosGuardados

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
        composable(PantallasApp.PartidosGuardados.ruta){ PartidosGuardados(navController, viewModel= DatosViewModel()) }
        composable("SENIOR"){ PartidoSenior(viewModel = DatosViewModel(), navController) }
        composable("S18"){ PartidoS18(viewModel = DatosViewModel(), navController) }
        composable("S14/S16/VET"){ PartidoS14S16VET(viewModel = DatosViewModel(), navController) }
        composable("S12"){ PartidoS12(viewModel = DatosViewModel(), navController) }
        composable("S10"){ PartidoS10(viewModel = DatosViewModel(), navController) }
        composable("S8"){ PartidoS8(viewModel = DatosViewModel(), navController) }
        composable("S6"){ PartidoS6(viewModel = DatosViewModel(), navController) }
    }
}