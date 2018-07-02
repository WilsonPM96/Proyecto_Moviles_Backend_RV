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

        boton_voz.setOnClickListener{
            view: View? ->  escucharvoz()
        }

    }
    fun registrarEstudiante(){
        intent = Intent(this, Usuarios::class.java)
        startActivity(intent)
    }

    fun escucharvoz(){
        intent = Intent(this, Voice2TextActivity::class.java)
        startActivity(intent)
    }
}
