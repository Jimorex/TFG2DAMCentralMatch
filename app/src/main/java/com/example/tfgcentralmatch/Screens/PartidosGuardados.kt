package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tfgcentralmatch.Model.DatosViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.tfgcentralmatch.Model.PartidoModel
import com.example.tfgcentralmatch.Model.getDataFromFirestore
import com.example.tfgcentralmatch.R
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PartidosGuardados(navController: NavHostController) {
    val backgroundColor = Color(0xFFB1B1CA)
    val textColor = Color(0xFF222232)
    val buttonColor = Color(0xFFD9D9D9)
    val colorTexto = Color(0xFFD9D9D9)
    val colorTabla = Color(0xFF222232)
    val imgFondo = painterResource(id = R.drawable.centralmatch)
    var Partido by remember { mutableStateOf<List<PartidoModel>>(emptyList()) }

    LaunchedEffect(Unit) {
        getDataFromFirestore { data ->
            Partido = data
        }
    }

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
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "PARTIDOS GUARDADOS",
                style = TextStyle(
                    color = textColor,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 75.dp, start = 5.dp, end = 5.dp)
                .fillMaxHeight(0.65f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight(0.7f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                items(Partido) { dataItem ->
                    Card(
                        onClick = { navController.navigate("PartidoGetBD/${dataItem.id}") },
                        modifier = Modifier
                            .padding(10.dp)
                            .size(400.dp, 150.dp)
                            .border(4.dp, textColor, shape = MaterialTheme.shapes.medium),
                        backgroundColor = buttonColor
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                dataItem.categoria,
                                color = textColor,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(0.dp),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                dataItem.nombrePartido,
                                color = textColor,
                                style = TextStyle(
                                    fontSize = 18.sp,
                                ),
                                modifier = Modifier
                                    .padding(5.dp),
                                textAlign = TextAlign.Center,
                            )
                            Text(
                                text = "${dataItem.local} - ${dataItem.visitante}",
                                color = textColor,
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(5.dp),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }

                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 550.dp),
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