package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tfgcentralmatch.Model.DatosViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.tfgcentralmatch.R
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun PartidosGuardados(navController: NavHostController, viewModel: DatosViewModel) {
    val backgroundColor = Color(0xFFB1B1CA)
    val textColor = Color(0xFF222232)
    val buttonColor = Color(0xFFD9D9D9)
    val colorTexto = Color(0xFFD9D9D9)
    val colorTabla = Color(0xFF222232)
    val imgFondo = painterResource(id = R.drawable.centralmatch)

    val db = FirebaseFirestore.getInstance()
    val coleccion = "partidos"
    var partidos = remember { mutableListOf(listOf<String>()) }
    LaunchedEffect(Unit) {
        db.collection(coleccion)
            .get()
            .addOnSuccessListener { result ->
            for (document in result) {
                val nombrePartido = document.getString("nombrePartido") ?: ""
                val categoria = document.getString("categoria") ?: ""
                val local = document.getString("local") ?: ""
                val visitante = document.getString("visitante") ?: ""
                partidos = (partidos + "$nombrePartido  $categoria $local - $visitante") as MutableList<List<String>>
            }
        }.addOnFailureListener { exception ->
            println("Error getting documents: $exception")
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
                .fillMaxHeight(0.73f)
                .alpha(0.7f),


            )
        LazyColumn {
            items(partidos) { partidos ->
                Text(text = partidos.get(0),
                    modifier = Modifier
                        .padding(5.dp),
                    )
            }
        }
    }
}