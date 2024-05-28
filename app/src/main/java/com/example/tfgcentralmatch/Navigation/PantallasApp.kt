package com.example.tfgcentralmatch.Navigation

sealed class PantallasApp (val ruta: String){

    object Inicio : PantallasApp("Inicio")
    object PartidoNuevo : PantallasApp("PartidoNuevo")
    object PartidosGuardados : PantallasApp("PartidosGuardados")
}