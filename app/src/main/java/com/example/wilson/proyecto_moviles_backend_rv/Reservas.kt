/*
package com.example.wilson.proyecto_moviles_backend_rv

import android.content.Intent
import android.util.Log
import android.widget.EditText
import org.json.JSONObject


private fun registrarEstudiante() {
    val nombreEstudiante: EditText = findViewById(R.id.editTxt_nombreEstudiante)
    val apellidoEstudiante: EditText = findViewById(R.id.editTxt_apellidoEstudiante)
    val json = JSONObject()
    json.put("idEstudiante", 1)
    json.put("nombres", nombreEstudiante.text)

    json.put("apellidos", apellidoEstudiante.text)

    json.put("fechaNacimiento", "25062018")

    json.put("semestreActual", 7)

    json.put("graduado", "Graduado")

    val httpRequest = Fuel.post("http://192.168.100.189:1337/Estudiante").body(json.toString())
    httpRequest.headers["Content-Type"] = "application/json"
    httpRequest.response { request, response, result ->

        Log.i("mensaje",request.toString())

        Log.i("mensaje",response.toString())

        Log.i("mensaje",result.toString())
    }

    val intent = Intent (this, MainActivity::class.java)
    finish()
    startActivity(intent)




}*/
