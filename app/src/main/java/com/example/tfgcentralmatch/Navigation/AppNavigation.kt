package com.example.tfgcentralmatch.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tfgcentralmatch.Model.DatosViewModel
import com.example.tfgcentralmatch.Screens.Inicio
import com.example.tfgcentralmatch.Screens.PartidoGetBD
import com.example.tfgcentralmatch.Screens.PartidoNuevo
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoS10
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoS12
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoS14

import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoS18
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoS6
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoS8
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoSenior
import com.example.tfgcentralmatch.Screens.PartidosGuardados
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoS16
import com.example.tfgcentralmatch.Screens.PartidosNuevos.PartidoVET

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigaton() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PantallasApp.Inicio.ruta
    ) {
        composable(PantallasApp.Inicio.ruta) { Inicio(navController) }
        composable(PantallasApp.PartidoNuevo.ruta) { PartidoNuevo(navController) }
        composable(PantallasApp.PartidosGuardados.ruta) { PartidosGuardados(navController) }
        composable("VET") { PartidoVET(viewModel = DatosViewModel(), navController) }
        composable("SENIOR") { PartidoSenior(viewModel = DatosViewModel(), navController) }
        composable("S18") { PartidoS18(viewModel = DatosViewModel(), navController) }
        composable("S16") { PartidoS16(viewModel = DatosViewModel(), navController) }
        composable("S14") { PartidoS14(viewModel = DatosViewModel(), navController) }
        composable("S12") { PartidoS12(viewModel = DatosViewModel(), navController) }
        composable("S10") { PartidoS10(viewModel = DatosViewModel(), navController) }
        composable("S8") { PartidoS8(viewModel = DatosViewModel(), navController) }
        composable("S6") { PartidoS6(viewModel = DatosViewModel(), navController) }
        composable("PartidoGetBD/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            id?.let { PartidoGetBD(it, navController) }
        }
    }
}