package com.example.tfgcentralmatch.Model

data class Partido(
    val id: String?,
    val nombre: String,
    val ensayos1: Int,
    val ensayos2: Int,
    val conversiones1: Int,
    val conversiones2: Int,
    val golpesCastigo1: Int,
    val golpesCastigo2: Int,
    val drop1: Int,
    val drop2: Int,
    val mele1: Int,
    val mele2: Int,
    val touche1: Int,
    val touche2: Int,
    val tarjetasAmarillas1: Int,
    val tarjetasAmarillas2: Int,
    val tarjetasRojas1: Int,
    val tarjetasRojas2: Int,

){
    fun toMap(): MutableMap<String, Any?> {
        return mutableMapOf(
            "nombre" to this.nombre,
            "ensayos1" to this.ensayos1,
            "ensayos2" to this.ensayos2,
            "conversiones1" to this.conversiones1,
            "conversiones2" to this.conversiones2,
            "golpesCastigo1" to this.golpesCastigo1,
            "golpesCastigo2" to this.golpesCastigo2,
            "drop1" to this.drop1,
            "drop2" to this.drop2,
            "mele1" to this.mele1,
            "mele2" to this.mele2,
            "touche1" to this.touche1,
            "touche2" to this.touche2,
            "tarjetasAmarillas1" to this.tarjetasAmarillas1,
            "tarjetasAmarillas2" to this.tarjetasAmarillas2,
            "tarjetasRojas1" to this.tarjetasRojas1,
            "tarjetasRojas2" to this.tarjetasRojas2
        )
    }
}
