package com.example.tfgcentralmatch.Model

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class DatosViewModel : ViewModel() {

    private val _nombrePartido = mutableStateOf("")
    private val _local = mutableStateOf(0)
    private val _visitante = mutableStateOf(0)
    private val _ensayos1 = mutableStateOf(0)
    private val _ensayos2 = mutableStateOf(0)
    private val _conversiones1 = mutableStateOf(0)
    private val _conversiones2 = mutableStateOf(0)
    private val _golpesCastigo1 = mutableStateOf(0)
    private val _golpesCastigo2 = mutableStateOf(0)
    private val _golpeFranco1 = mutableStateOf(0)
    private val _golpeFranco2 = mutableStateOf(0)
    private val _drop1 = mutableStateOf(0)
    private val _drop2 = mutableStateOf(0)
    private val _avant1 = mutableStateOf(0)
    private val _avant2 = mutableStateOf(0)
    private val _mele1 = mutableStateOf(0)
    private val _mele2 = mutableStateOf(0)
    private val _touche1 = mutableStateOf(0)
    private val _touche2 = mutableStateOf(0)
    private val _tarjetasAmarillas1 = mutableStateOf(0)
    private val _tarjetasAmarillas2 = mutableStateOf(0)
    private val _tarjetasRojas1 = mutableStateOf(0)
    private val _tarjetasRojas2 = mutableStateOf(0)
    private val _categoria = mutableStateOf("")

    val categoria : State<String> = _categoria
    val nombrePartido : State<String> = _nombrePartido
    val local : State<Int> = _local
    val visitante : State<Int> = _visitante
    val ensayos1 : State<Int> = _ensayos1
    val ensayos2 : State<Int> = _ensayos2
    val conversiones1 : State<Int> = _conversiones1
    val conversiones2 : State<Int> = _conversiones2
    val golpesCastigo1 : State<Int> = _golpesCastigo1
    val golpesCastigo2 : State<Int> = _golpesCastigo2
    val drop1 : State<Int> = _drop1
    val drop2 : State<Int> = _drop2
    val avant1: State<Int> = _avant1
    val avant2: State<Int> = _avant2
    val mele1 : State<Int> = _mele1
    val mele2 : State<Int> = _mele2
    val touche1 : State<Int> = _touche1
    val touche2 : State<Int> = _touche2
    val tarjetasAmarillas1 : State<Int> = _tarjetasAmarillas1
    val tarjetasAmarillas2 : State<Int> = _tarjetasAmarillas2
    val tarjetasRojas1 : State<Int> = _tarjetasRojas1
    val tarjetasRojas2 : State<Int> = _tarjetasRojas2
    val golpeFranco1 : State<Int> = _golpeFranco1
    val golpeFranco2 : State<Int> = _golpeFranco2

    fun sumarEnsayoLocal() {
        _ensayos1.value = _ensayos1.value + 1
        _local.value = _local.value + 5
    }
    fun restarEnsayoLocal() {
        if (_ensayos1.value > 0) {
            _ensayos1.value = _ensayos1.value - 1
            _local.value = _local.value - 5
        }
    }
    fun sumarEnsayoVisitante() {
        _ensayos2.value = _ensayos2.value + 1
        _visitante.value = _visitante.value + 5
    }
    fun restarEnsayoVisitante() {
        if (_ensayos2.value > 0) {
            _ensayos2.value = _ensayos2.value - 1
            _visitante.value = _visitante.value - 5
        }
    }
    fun sumarConversionLocal() {
        _conversiones1.value = _conversiones1.value + 1
        _local.value = _local.value + 2
    }
    fun restarConversionLocal() {
        if (_conversiones1.value > 0) {
            _conversiones1.value = _conversiones1.value - 1
            _local.value = _local.value - 2
        }
    }
    fun sumarConversionVisitante() {
        _conversiones2.value = _conversiones2.value + 1
        _visitante.value = _visitante.value + 2
    }
    fun restarConversionVisitante() {
        if (_conversiones2.value > 0) {
            _conversiones2.value = _conversiones2.value - 1
            _visitante.value = _visitante.value - 2
        }
    }
    fun sumarDropLocal() {
        _drop1.value = _drop1.value + 1
        _local.value = _local.value + 3
    }
    fun restarDropLocal() {
        if (_drop1.value > 0) {
            _drop1.value = _drop1.value - 1
            _local.value = _local.value - 3
        }
    }
    fun sumarDropVisitante() {
        _drop2.value = _drop2.value + 1
        _visitante.value = _visitante.value + 3
    }
    fun restarDropVisitante() {
        if (_drop2.value > 0) {
            _drop2.value = _drop2.value - 1
            _visitante.value = _visitante.value - 3
        }
    }
    fun sumarMeleLocal() {
        _mele1.value = _mele1.value + 1
    }
    fun restarMeleLocal() {
        if (_mele1.value > 0) {
            _mele1.value = _mele1.value - 1
        }
    }
    fun sumarMeleVisitante() {
        _mele2.value = _mele2.value + 1
    }
    fun restarMeleVisitante() {
        if (_mele2.value > 0) {
            _mele2.value = _mele2.value - 1
        }
    }
    fun sumarAvantLocal() {
        _avant1.value = _avant1.value + 1
    }
    fun restarAvantLocal() {
        if (_avant1.value > 0) {
            _avant1.value = _avant1.value - 1
        }
    }
    fun sumarAvantVisitante() {
        _avant2.value = _avant2.value + 1
    }
    fun restarAvantVisitante() {
        if (_avant2.value > 0) {
            _avant2.value = _avant2.value - 1
        }
    }
    fun sumarToucheLocal() {
        _touche1.value = _touche1.value + 1
    }
    fun restarToucheLocal() {
        if (_touche1.value > 0) {
            _touche1.value = _touche1.value - 1
        }
    }
    fun sumarToucheVisitante() {
        _touche2.value = _touche2.value + 1
    }
    fun restarToucheVisitante() {
        if (_touche2.value > 0) {
            _touche2.value = _touche2.value - 1
        }
    }
    fun sumarGolpeCastigoLocal() {
        _golpesCastigo1.value = _golpesCastigo1.value + 1
    }
    fun restarGolpeCastigoLocal() {
        if (_golpesCastigo1.value > 0) {
            _golpesCastigo1.value = _golpesCastigo1.value - 1
        }
    }
    fun sumarGolpeCastigoVisitante() {
        _golpesCastigo2.value = _golpesCastigo2.value + 1
    }
    fun restarGolpeCastigoVisitante() {
        if (_golpesCastigo2.value > 0) {
            _golpesCastigo2.value = _golpesCastigo2.value - 1
        }
    }
    fun sumarGolpeFrancoLocal() {
        _golpeFranco1.value = _golpeFranco1.value + 1
    }
    fun restarGolpeFrancoLocal() {
        if (_golpeFranco1.value > 0) {
            _golpeFranco1.value = _golpeFranco1.value - 1
        }
    }
    fun sumarGolpeFrancoVisitante() {
        _golpeFranco2.value = _golpeFranco2.value + 1
    }
    fun restarGolpeFrancoVisitante() {
        if (_golpeFranco2.value > 0) {
            _golpeFranco2.value = _golpeFranco2.value - 1
        }
    }
    fun sumarTarjetaAmarillaLocal() {
        _tarjetasAmarillas1.value = _tarjetasAmarillas1.value + 1
    }
    fun restarTarjetaAmarillaLocal() {
        if (_tarjetasAmarillas1.value > 0) {
            _tarjetasAmarillas1.value = _tarjetasAmarillas1.value - 1
        }
    }
    fun sumarTarjetaAmarillaVisitante() {
        _tarjetasAmarillas2.value = _tarjetasAmarillas2.value + 1
    }
    fun restarTarjetaAmarillaVisitante() {
        if (_tarjetasAmarillas2.value > 0) {
            _tarjetasAmarillas2.value = _tarjetasAmarillas2.value - 1
        }
    }
    fun sumarTarjetaRojaLocal() {
        _tarjetasRojas1.value = _tarjetasRojas1.value + 1
    }
    fun restarTarjetaRojaLocal() {
        if (_tarjetasRojas1.value > 0) {
            _tarjetasRojas1.value = _tarjetasRojas1.value - 1
        }
    }
    fun sumarTarjetaRojaVisitante() {
        _tarjetasRojas2.value = _tarjetasRojas2.value + 1
    }
    fun restarTarjetaRojaVisitante() {
        if (_tarjetasRojas2.value > 0) {
            _tarjetasRojas2.value = _tarjetasRojas2.value - 1
        }
    }

    private val db = FirebaseFirestore.getInstance()

    fun guardarPartido(nombrePartido : String, categoria : String){
        val partido = hashMapOf(

            "categoria" to categoria,
            "nombrePartido" to nombrePartido,
            "local" to local.value,
            "visitante" to visitante.value,
            "ensayos1" to ensayos1.value,
            "ensayos2" to ensayos2.value,
            "conversiones1" to conversiones1.value,
            "conversiones2" to conversiones2.value,
            "golpesCastigo1" to golpesCastigo1.value,
            "golpesCastigo2" to golpesCastigo2.value,
            "drop1" to drop1.value,
            "drop2" to drop2.value,
            "avant1" to avant1.value,
            "avant2" to avant2.value,
            "mele1" to mele1.value,
            "mele2" to mele2.value,
            "touche1" to touche1.value,
            "touche2" to touche2.value,
            "tarjetasAmarillas1" to tarjetasAmarillas1.value,
            "tarjetasAmarillas2" to tarjetasAmarillas2.value,
            "tarjetasRojas1" to tarjetasRojas1.value,
            "tarjetasRojas2" to tarjetasRojas2.value,
            "golpeFranco1" to golpeFranco1.value,
            "golpeFranco2" to golpeFranco2.value
        )
        db.collection("partidos")
            .add(partido)
            .addOnSuccessListener { documentReference ->
                println("DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                println("Error adding document: $e")
            }

    }

}