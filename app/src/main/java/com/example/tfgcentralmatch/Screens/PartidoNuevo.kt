package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun PartidoNuevo(navController: NavController) {
    val backgroundColor = Color(0xFFB1B1CA)

    Box() {
        Column {
            Marcador() }
        Column {
            Cronometro()
            Datos()

        }
    }
}