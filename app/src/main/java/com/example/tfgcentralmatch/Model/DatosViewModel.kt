package com.example.tfgcentralmatch.Model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DatosViewModel : ViewModel() {

    private val _local = mutableStateOf(0)
    private val _visitante = mutableStateOf(0)
    private val _ensayos1 = mutableStateOf(0)
    private val _ensayos2 = mutableStateOf(0)
    private val _conversiones1 = mutableStateOf(0)
    private val _conversiones2 = mutableStateOf(0)
    private val _golpesCastigo1 = mutableStateOf(0)
    private val _golpesCastigo2 = mutableStateOf(0)
    private val _drop1 = mutableStateOf(0)
    private val _drop2 = mutableStateOf(0)
    private val _mele1 = mutableStateOf(0)
    private val _mele2 = mutableStateOf(0)
    private val _touche1 = mutableStateOf(0)
    private val _touche2 = mutableStateOf(0)
    private val _tarjetasAmarillas1 = mutableStateOf(0)
    private val _tarjetasAmarillas2 = mutableStateOf(0)
    private val _tarjetasRojas1 = mutableStateOf(0)
    private val _tarjetasRojas2 = mutableStateOf(0)

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
}