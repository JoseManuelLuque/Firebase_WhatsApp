package com.jluqgon214.whatsapppruebas.model

data class Mensaje(
    val contenido: String,
    val remitente: Contacto,
    val destinatario: Int,
    val timestamp: Long = System.currentTimeMillis()
)