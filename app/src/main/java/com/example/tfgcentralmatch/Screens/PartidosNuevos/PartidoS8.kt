package com.example.tfgcentralmatch.Screens.PartidosNuevos

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tfgcentralmatch.Model.DatosViewModel
import com.example.tfgcentralmatch.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PartidoS8(viewModel: DatosViewModel, navController : NavController){

    var timePassed by remember { mutableStateOf(0L) } // En milisegundos
    var isRunning by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val backgroundColor = Color(0xFFB1B1CA)
    val textColor = Color(0xFF222232)
    val buttonColor = Color(0xFFD9D9D9)
    val colorTexto = Color(0xFFD9D9D9)
    val colorTabla = Color(0xFF222232)
    val imgFondo = painterResource(id = R.drawable.centralmatch)
    var nombrePartido by remember { mutableStateOf(viewModel.nombrePartido.value) }
    var categoria by remember { mutableStateOf(viewModel.categoria.value) }

    categoria = "S8"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(5.dp),
        contentAlignment = Alignment.TopCenter,
    ) {
        Image(
            painter = imgFondo,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .fillMaxHeight(0.73f)
                .alpha(0.7f),


            )
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
                    fontSize = 18.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${viewModel.local.value.toString()} - ${viewModel.visitante.value.toString()}",
                    fontSize = 40.sp,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 16.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "EQUIPO 2",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.End
                )
            }
        }
    }
    Column(
        modifier = Modifier
            .padding(top = 101.dp, end = 96.dp, start = 96.dp),
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
                text = String.format("%02d:%02d", timePassed / 60000, (timePassed % 60000) / 1000),
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
                            while (isRunning && timePassed < 1200000) { //20 minutos totales
                                delay(1000)
                                timePassed += 1000
                                if (timePassed.toInt() == 600000) { // Pausa en 10:00
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
                    .size(80.dp, 50.dp)
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
                    .padding(top = 250.dp, start = 5.dp, end = 5.dp)
                    .fillMaxHeight(0.3f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            ) { 
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorTabla.copy(alpha = 0.8f)),
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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight(0.56f)
                        .background(colorTabla.copy(alpha = 0.7f))

                ){
                    //Ensayos
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { viewModel.sumarEnsayoLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarEnsayoLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Text(
                                text = "${viewModel.ensayos1.value.toString()} - Ensayos - ${viewModel.ensayos2.value.toString()}",
                                color = colorTexto,
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Button(
                                onClick = { viewModel.sumarEnsayoVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarEnsayoVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                        }
                    }
                    //Avant
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { viewModel.sumarAvantLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarAvantLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Text(
                                text = "${viewModel.avant1.value.toString()} - Avants - ${viewModel.avant2.value.toString()}",
                                color = colorTexto,
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Button(
                                onClick = { viewModel.sumarAvantVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarAvantVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                        }
                    }
                    //Fueras
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { viewModel.sumarToucheLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarToucheLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Text(
                                text = "${viewModel.touche1.value.toString()} - Fueras - ${viewModel.touche2.value.toString()}",
                                color = colorTexto,
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Button(
                                onClick = { viewModel.sumarToucheVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarToucheVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                        }
                    }
                    //Golpes de castigo
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = { viewModel.sumarGolpeCastigoLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarGolpeCastigoLocal() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)

    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Text(
                                text = "${viewModel.golpesCastigo1.value.toString()} - G. Castigo - ${viewModel.golpesCastigo2.value.toString()}",
                                color = colorTexto,
                                fontSize = 16.sp,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                            Button(
                                onClick = { viewModel.sumarGolpeCastigoVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "+",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                            Button(
                                onClick = { viewModel.restarGolpeCastigoVisitante() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                                modifier = Modifier
                                    .size(40.dp, 40.dp)
                                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
    
                            ) {
                                Text(
                                    text = "-",
                                    fontSize = 15.sp,
                                    color = textColor
                                )
                            }
                        }
                    }
                }
            }
            Column (
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TextField(
                    value = nombrePartido,
                    onValueChange = {if (it.length <= 30) { nombrePartido = it }},
                    label = { Text("Nombre del partido", color = textColor) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = buttonColor,
                        textColor = textColor,
                        cursorColor = textColor,
                        focusedIndicatorColor = textColor,
                        unfocusedIndicatorColor = textColor
                    ),
                    singleLine = true, // Evita saltos de línea
                    modifier = Modifier
                        .padding(8.dp)
                )
                Row {
                    Button(
                        onClick = {viewModel.guardarPartido(nombrePartido,categoria)
                            navController.popBackStack() },
                        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(120.dp, 50.dp)
                            .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)) {
                        Text("GUARDAR")
                    }
                    Button(onClick = { navController.popBackStack() },
                        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(120.dp, 50.dp)
                            .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)) {
                        Text("VOLVER")
                    }
                }
            }
        }