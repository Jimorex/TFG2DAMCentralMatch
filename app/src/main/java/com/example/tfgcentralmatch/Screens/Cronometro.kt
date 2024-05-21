package com.example.tfgcentralmatch.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun Cronometro() {
    var timePassed by remember { mutableStateOf(0L) } // En milisegundos
    var isRunning by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val backgroundColor = Color(0xFFB1B1CA)
    val buttonColor = Color(0xFFD9D9D9)
    val textColor = Color(0xFF222232)

    Column(
        modifier = Modifier .padding(top =  96.dp, end = 96.dp, start = 96.dp) .background(backgroundColor),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        
        Box(
            modifier = Modifier.fillMaxWidth().border(4.dp, textColor) .background(buttonColor),
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
                    .size(100.dp, 50.dp)
                    .border(4.dp, textColor, shape = MaterialTheme.shapes.medium)


            ) {
                Text(if (isRunning) "PARAR" else "EMPEZAR",
                    color = textColor,
                    style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold)
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
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}