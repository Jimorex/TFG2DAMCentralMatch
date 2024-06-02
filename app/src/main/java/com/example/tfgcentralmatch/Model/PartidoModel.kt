package com.example.tfgcentralmatch.Model

data class PartidoModel(

    val id: String,
    val nombrePartido: String,
    val local: Int,
    val visitante: Int,
    val ensayos1: Int,
    val ensayos2: Int,
    val conversiones1: Int,
    val conversiones2: Int,
    val golpesCastigo1 : Int,
    val golpesCastigo2 : Int,
    val golpeFranco1 : Int,
    val golpeFranco2 : Int,
    val drop1 : Int,
    val drop2 : Int,
    val avant1: Int,
    val avant2: Int,
    val mele1 : Int,
    val mele2 : Int,
    val touche1 : Int,
    val touche2 : Int,
    val tarjetasAmarillas1 : Int,
    val tarjetasAmarillas2 : Int,
    val tarjetasRojas1 : Int,
    val tarjetasRojas2 : Int,
    val categoria: String,
){
    constructor() : this("","",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"")
}