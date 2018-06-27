package com.example.wilson.proyecto_moviles_backend_rv

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_registrar_usuario.setOnClickListener{
            view: View? -> registrarEstudiante()
        }

    }
    fun registrarEstudiante(){
        intent = Intent(this, Usuarios::class.java)
        startActivity(intent)
    }
}
