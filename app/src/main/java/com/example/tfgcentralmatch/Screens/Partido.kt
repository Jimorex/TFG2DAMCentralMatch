package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tfgcentralmatch.Model.DatosViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun Partido(viewModel: DatosViewModel){

    var timePassed by remember { mutableStateOf(0L) } // En milisegundos
    var isRunning by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val backgroundColor = Color(0xFFB1B1CA)
    val textColor = Color(0xFF222232)
    val buttonColor = Color(0xFFD9D9D9)
    val colorTexto = Color(0xFFD9D9D9)
    val colorTabla = Color(0xFF222232)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(3.dp, textColor)
                    .background(buttonColor),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "EQUIPO 1",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "${viewModel.local.value.toString()} - ${viewModel.visitante.value}",
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
    Column(
        modifier = Modifier
            .padding(top = 96.dp, end = 96.dp, start = 96.dp)
            .background(backgroundColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(4.dp, textColor)
                .background(buttonColor),
            contentAlignment = Alignment.TopCenter,

            ) {
            Text(
                text = "${timePassed / 60000}:${(timePassed % 60000) / 1000}",
                fontSize = 50.sp,
            )
        }
        Row(
            modifier = Modifier.padding(top = 16.dp),
            //horizontalArrangement = Arrangement.SpaceEvenly
            //verticalArrangement = Arrangement.Top,
            //horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Button(
                onClick = {
                    isRunning = !isRunning
                    if (isRunning) {
                        scope.launch {
                            while (isRunning && timePassed < 4800000) {
                                delay(1000)
                                timePassed += 1000
                                if (timePassed.toInt() == 2400000) { // Pausa en 40:00
                                    isRunning = false
                                }
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(80.dp, 50.dp)
                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)


            ) {
                Text(if (isRunning) "PARAR" else "EMPEZAR",
                    color = textColor,
                    style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Bold)
                )
            }

            Button(onClick = {
                timePassed = 0
                isRunning = false
            },colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                modifier = Modifier
                    .size(103.dp, 50.dp)
                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)) {
                Text("REINICIAR",
                    color = textColor,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
    Column(
        modifier = Modifier
            .padding(top = 250.dp)
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
                    .padding(bottom = 1.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { viewModel.sumarEnsayoLocal() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                ) {
                    Text(text = "+")
                }
                Button(
                    onClick = { viewModel.restarEnsayoLocal() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                    ) {
                    Text(text = "-")
                }
                Text(
                    text =  "${viewModel.ensayos1.value.toString()} - Ensayos - ${viewModel.ensayos2.value.toString()}",
                    color = colorTexto,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Button(
                    onClick = { viewModel.sumarEnsayoVisitante() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                ) {
                    Text(text = "+")
                }
                Button(
                    onClick = { viewModel.restarEnsayoVisitante() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                    ) {
                    Text(text = "-")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 1.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(
                    onClick = { viewModel.sumarConversionLocal() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                    ) {
                    Text(text ="+")
                }
                Button(
                    onClick = { viewModel.restarConversionLocal() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                ) {
                    Text(text ="-")
                }
                Text(
                    text =  "${viewModel.conversiones1.value.toString()} - Conversión - ${viewModel.conversiones2.value.toString()}",
                    color = colorTexto,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Button(
                    onClick = { viewModel.sumarConversionVisitante() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                ) {
                    Text(text = "+")
                }
                Button(
                    onClick = { viewModel.restarConversionVisitante() },
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                ) {
                    Text(text = "-")
                }
            }

        }
    }
}