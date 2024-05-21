package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tfgcentralmatch.Model.DatosViewModel
import com.example.tfgcentralmatch.Model.Partido
import java.util.stream.Collectors.toMap

@Preview(showBackground = true)
@Composable
fun Datos( viewModel: DatosViewModel ){
    val colorTexto = Color(0xFFD9D9D9)
    val colorTabla = Color(0xFF222232)

    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(colorTabla.copy(alpha = 0.95f)),
    verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorTabla.copy(alpha = 0.95f)),
            contentAlignment = Alignment.TopCenter,

        ) {
            Text(
                text = "DATOS DEL PARTIDO",
                color = colorTexto,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
        Box{

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { viewModel.sumarEnsayoLocal() }) {
                    Text(text = "+")
                }
                Button(onClick = {viewModel.restarEnsayoLocal() }) {
                    Text(text = "-")
                }
                Text(
                    text =  "${viewModel.ensayos1.value.toString()} - Ensayos - ${viewModel.ensayos2.value.toString()}",
                    color = colorTexto,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Button(onClick = { viewModel.sumarEnsayoVisitante()}) {
                    Text(text = "+")
                }
                Button(onClick = { viewModel.restarEnsayoVisitante()}) {
                    Text(text = "-")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { viewModel.sumarEnsayoLocal() }) {
                    Text(text = "+")
                }
                Button(onClick = {viewModel.restarEnsayoLocal() }) {
                    Text(text = "-")
                }
                Text(
                    text =  "${viewModel.ensayos1.value.toString()} - Ensayos - ${viewModel.ensayos2.value.toString()}",
                    color = colorTexto,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Button(onClick = { viewModel.sumarEnsayoVisitante()}) {
                    Text(text = "+")
                }
                Button(onClick = { viewModel.restarEnsayoVisitante()}) {
                    Text(text = "-")
                }
            }

        }
    }
}