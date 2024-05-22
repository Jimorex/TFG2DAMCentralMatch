package com.example.tfgcentralmatch.Model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

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

    //ENSAYOS
     //ENSAYOS
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
    //CONVERSIONES
    //CONVERSIONES
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
    //DROP
    //DROP
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
    //MELE
    //MELE
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
    //AVANT
    //AVANT
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
    //TOUCHE
    //TOUCHE
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
    //GOLPES DE CASTIGO
    //GOLPES DE CASTIGO
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
    //GOLPE FRANCO
    //GOLPE FRANCO
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
    //TARJETAS AMARILLAS
    //TARJETAS AMARILLAS
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
    //TARJETAS ROJAS
     //TARJETAS ROJAS
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
}