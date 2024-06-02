package com.example.tfgcentralmatch.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.tfgcentralmatch.R

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PartidoNuevo(navController: NavController) {

    val backgroundColor = Color(0xFFB1B1CA)
    val textColor = Color(0xFF222232)
    val buttonColor = Color(0xFFD9D9D9)
    val colorTexto = Color(0xFFD9D9D9)
    val colorTabla = Color(0xFF222232)
    val imgFondo = painterResource(id = R.drawable.centralmatch)
    val categorias = listOf("S6", "S8", "S10", "S12", "S14", "S16", "S18", "SENIOR", "VET")

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
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding( 20.dp)
        ){
            Text(text = "SELECCIONA UNA CATEGORÍA",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = textColor,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                ),

                modifier = Modifier
                    .padding( 15.dp)
                    .align(Alignment.Center)
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 110.dp)
                .fillMaxHeight(0.7f),

        ) {
            items(categorias) { categoria ->
                Button(
                    onClick = { navController.navigate(categoria) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                    modifier = Modifier
                        .padding(10.dp)
                        .size(225.dp, 75.dp)
                        .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
                ) {
                    Text(
                        categoria,
                        color = textColor,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }

            Button(onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                modifier = Modifier
                    .padding(top = 585.dp, bottom = 40.dp)
                    .size(250.dp, 70.dp)
                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)) {
                Text("VOLVER",
                    color = textColor,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ))
            }
        }
    }