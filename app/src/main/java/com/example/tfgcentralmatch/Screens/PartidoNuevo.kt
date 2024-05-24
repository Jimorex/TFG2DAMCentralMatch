package com.example.tfgcentralmatch.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tfgcentralmatch.Model.DatosViewModel
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
    val categorias = listOf("SUB-S6", "SUB-8", "SUB-10", "SUB-12", "SUB-14/SUB-16/VET", "SUB-18", "SENIOR")

    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 80.dp)
    ){
        categorias.forEach { categoria ->
            Button(
                onClick = { navController.navigate(categoria) },
                colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
                modifier = Modifier
                    .padding(10.dp)
                    .size(200.dp, 60.dp)
                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)
                ) {
                Text(categoria,
                    color = textColor,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    )
            }
        }
    }
}