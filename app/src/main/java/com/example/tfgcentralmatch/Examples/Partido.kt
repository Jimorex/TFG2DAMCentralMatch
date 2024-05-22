package com.example.tfgcentralmatch.Examples


data class Partido(
    val id: String?,
    val nombre: String,
    var ensayos1: Int,
    internal var ensayos2: Int,
    private val conversiones1: Int,
    private val conversiones2: Int,
    private val golpesCastigo1: Int,
    private val golpesCastigo2: Int,
    private val drop1: Int,
    private val drop2: Int,
    private val mele1: Int,
    private val mele2: Int,
    private val touche1: Int,
    private val touche2: Int,
    private val tarjetasAmarillas1: Int,
    private val tarjetasAmarillas2: Int,
    private val tarjetasRojas1: Int,
    private val tarjetasRojas2: Int,

    ){

    fun sumarEnsayoLocal() {
        ensayos1 = ensayos1 + 1
    }

    fun sumarEnsayoVisitante() {
        ensayos2 = ensayos2 + 1
    }

    fun restarEnsayoLocal() {
        if (ensayos1 > 0) {
            ensayos1 = ensayos1 - 1
        }
    }

    fun restarEnsayoVisitante() {
        if (ensayos2 > 0) {
            ensayos2 = ensayos2 - 1
        }
    }


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
