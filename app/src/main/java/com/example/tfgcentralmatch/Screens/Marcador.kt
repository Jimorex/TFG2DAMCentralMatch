package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tfgcentralmatch.AppMarcador

@Preview(showBackground = true)
@Composable
fun Marcador() {

    val marcador = AppMarcador()
    val local = marcador.local
    val visitante = marcador.visitante
    val backgroundColor = Color(0xFFB1B1CA)
    val textColor = Color(0xFF222232)
    val buttonColor = Color(0xFFD9D9D9)




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background (backgroundColor),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth() .border(3.dp, textColor) .background(buttonColor),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "EQUIPO 1",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "$local - $visitante",
                    fontSize = 50.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)

                )
                Text(
                    text = "EQUIPO 2",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)

                )
            }

        }
    }
}