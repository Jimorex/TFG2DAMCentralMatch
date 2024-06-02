package com.example.tfgcentralmatch.Model

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

fun getDataFromFirestore(onDataReceived: (List<PartidoModel>) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    db.collection("partidos")
        .get()
        .addOnSuccessListener { result ->
            println("¡¡Petición a la base de datos realizada con éxito!!")
            val dataList = mutableListOf<PartidoModel>()
            for (document in result) {
                val partido = document.toObject<PartidoModel>()
                dataList.add(partido)
            }
            onDataReceived(dataList)
        }
        .addOnFailureListener { exception ->
            println("¡¡ERROR!! en la petición a la base de datos : $exception")
        }
}
