package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tfgcentralmatch.R

@Composable
fun Inicio(navController: NavHostController) {
    val backgroundColor = Color(0xFF4B4B4B)
    val buttonColor = Color(0xFFD9D9D9)
    val textColor = Color(0xFF222232)
    val imgFondo = painterResource(id = R.drawable.centralmatch)
    val imgLogo = painterResource(id = R.drawable.logo)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = imgFondo,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .fillMaxHeight(0.73f)

        )
        Image(
            painter = imgLogo,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 16.dp, start = 16.dp)
                .fillMaxHeight(0.3f)
                .size(400.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { /*TODO: Handle click*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                modifier = Modifier
                    .padding(bottom = 25.dp)
                    .size(200.dp, 60.dp)
                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
            ) {
                Text(
                    text = "NUEVO PARTIDO",
                    color = textColor,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ))
            }

            Button(
                onClick = { /*TODO: Handle click*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                modifier = Modifier
                    .size(200.dp, 60.dp)
                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)

            ) {
                Text(text = "CARGAR PARTIDO",
                    color = textColor,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ))
            }
        }
    }
}