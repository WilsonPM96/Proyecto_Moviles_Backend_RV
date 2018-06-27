package com.example.wilson.proyecto_moviles_backend_rv

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_success.*
import org.json.JSONObject
class Usuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        button_registrar.setOnClickListener{
            view: View? ->  registrarEstudiante()
        }

    }


    private fun registrarEstudiante() {
        val nombreUsuario: EditText = findViewById(R.id.editText_nombre)
        val apellidoUsuario: EditText = findViewById(R.id.editText_apellido)
        val telefonoUsuario: EditText = findViewById(R.id.editText_telefono)
        val passwordUsuario: EditText = findViewById(R.id.editText_pass)
        val json = JSONObject()
        json.put("idUsuario", 1)
        json.put("nombre", nombreUsuario.text)

        json.put("apellido", apellidoUsuario.text)

        json.put("telefono", telefonoUsuario.text.toString().toInt())

        json.put("password", passwordUsuario.text)


        val httpRequest = Fuel.post("http://192.168.100.189:1337/Usuarios").body(json.toString())
        httpRequest.headers["Content-Type"] = "application/json"
        httpRequest.response { request, response, result ->

            Log.i("mensaje", request.toString())

            Log.i("mensaje", response.toString())

            Log.i("mensaje", result.toString())
        }

        val intent = Intent (this, MainActivity::class.java)
        finish()
        startActivity(intent)


    }

}