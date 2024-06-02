package com.example.tfgcentralmatch.Screens

import android.annotation.SuppressLint
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tfgcentralmatch.Model.PartidoModel
import com.example.tfgcentralmatch.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

@Preview(showBackground = true)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PartidoGetBD(id: String, navController: NavController) {

    val backgroundColor = Color(0xFFB1B1CA)
    val textColor = Color(0xFF222232)
    val buttonColor = Color(0xFFD9D9D9)
    val colorTexto = Color(0xFFD9D9D9)
    val colorTabla = Color(0xFF222232)
    val imgFondo = painterResource(id = R.drawable.centralmatch)
    var partido by remember { mutableStateOf<PartidoModel?>(null) }

    LaunchedEffect(id) {
        val db = FirebaseFirestore.getInstance()
        db.collection("partidos").document(id)
            .get()
            .addOnSuccessListener { document ->
                partido = document.toObject<PartidoModel>()
                println("¡¡Petición a la base de datos realizada con éxito!!")
            }
            .addOnFailureListener { exception ->
                // Manejar errores aquí
            }
    }
    partido?.let {

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
                    .fillMaxHeight(1f)
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
                ) {
                    Text(
                        text = "EQUIPO 1",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                            .padding(start = 8.dp)
                            .weight(1f),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "${it.local} - ${it.visitante}",
                        fontSize = 40.sp,
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "EQUIPO 2",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .align(CenterVertically)
                            .padding(end = 8.dp)
                            .weight(1f),
                        textAlign = TextAlign.End
                    )
                }
            }
            Column (modifier = Modifier
                .padding(top = 110.dp, bottom = 10.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = it.nombrePartido,
                    color = colorTabla,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(text = it.categoria,
                    color = colorTabla,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 175.dp, start = 5.dp, end = 5.dp),
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
                Box (contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                ){

                LazyColumn(
                    modifier = Modifier.background(colorTabla.copy(alpha = 0.7f)),
                ) {
                    if (it.categoria =="S6" || it.categoria =="S8"){
                        //Ensayos
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.ensayos1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Ensayos",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.ensayos2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Avant
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.avant1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Avants",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.avant2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Touches
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.touche1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Fueras",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.touche2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Golpes de castigo
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding ( bottom = 5.dp),
                                horizontalArrangement = Arrangement.Center

                            ) {
                                Text(
                                    text = "${it.golpesCastigo1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Golpe de Castigo",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                )
                                Text(
                                    text = "${it.golpesCastigo2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                    }
                    else if (it.categoria == "S10" || it.categoria == "S12") {
                        //Ensayos
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.ensayos1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Ensayos",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.ensayos2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Avant
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.avant1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Avants",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.avant2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Melés
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.mele1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Melés",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.mele2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Touches
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.touche1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Touches",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.touche2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Golpes de castigo
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center

                            ) {
                                Text(
                                    text = "${it.golpesCastigo1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)

                                )
                                Text(
                                    text = "Golpe de Castigo",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                )
                                Text(
                                    text = "${it.golpesCastigo2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp)

                                )
                            }
                        }
                        //Tarjetas Amarillas
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding ( bottom = 5.dp),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.tarjetasAmarillas1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Tarjetas Amarillas",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.tarjetasAmarillas2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                    }
                    else if (it.categoria == "S14" || it.categoria == "S16" || it.categoria == "VET" || it.categoria == "SENIOR" || it.categoria == "S18"){
                        //Ensayos
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.ensayos1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Ensayos",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.ensayos2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Conversiones
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.conversiones1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Conversiones",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.conversiones2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Drop
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.drop1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Drop Goals",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.drop2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Avant
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.avant1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Avants",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.avant2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Melés
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.mele1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Melés",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.mele2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Touches
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.touche1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Touches",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.touche2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Golpes de castigo
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center

                            ) {
                                Text(
                                    text = "${it.golpesCastigo1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Golpe de Castigo",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                )
                                Text(
                                    text = "${it.golpesCastigo2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp)

                                )
                            }
                        }
                        //Golpes franco
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.golpeFranco1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Golpes Francos",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.golpeFranco2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Tarjetas Amarillas
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.tarjetasAmarillas1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Tarjetas Amarillas",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.tarjetasAmarillas2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                        //Tarjetas Rojas
                        item {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding ( bottom = 5.dp),
                                horizontalArrangement = Arrangement.Center
                            ){
                                Text(
                                    text = "${it.tarjetasRojas1}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp)
                                )
                                Text(
                                    text = "Tarjetas Rojas",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    text = "${it.tarjetasRojas2}",
                                    color = colorTexto,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 30.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(top = 600.dp, bottom = 30.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(120.dp, 50.dp)
                        .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
                ) {
                    Text("VOLVER")
                }
            }
        }
        }
    }
}