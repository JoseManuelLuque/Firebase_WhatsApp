package com.jluqgon214.whatsapppruebas.data

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.jluqgon214.whatsapppruebas.R
import com.jluqgon214.whatsapppruebas.model.Contacto


class TestDB() {
    val user = hashMapOf(
        "first" to "Ada",
        "last" to "Lovelace",
        "born" to 1815,
    )
    val contactoObjeto = Contacto("Paco", R.drawable.c4, 22)
    val contacto = hashMapOf(
        "nombre" to contactoObjeto.nombre,
        "foto" to contactoObjeto.fotoPerfil,
        "id" to contactoObjeto.id
    )

    fun agregarColleccion(db: FirebaseFirestore) {
        db.collection("users")
            .add(contacto)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    fun leerDatos(db: FirebaseFirestore) {
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}