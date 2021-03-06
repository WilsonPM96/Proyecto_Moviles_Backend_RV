
package com.example.wilson.proyecto_moviles_backend_rv

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_success.*
import org.json.JSONObject
import java.util.*

class Reservas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
       // button_registrar.setOnClickListener{
         //   view: View? ->  registrarUsuario()
        //}

    }
   /* private fun buscarReserva() {
        "http://172.31.104.18:1337/Usuario/1"
                .httpGet()
                .responseString { request, response, result ->
                    when (result) {
                        is Result.Failure -> {
                            val ex = result.getException()
                            Log.i("http-ejemplo", "Error ${ex.response}")
                        }
                        is Result.Success -> {
                            val jsonStringUsuario = result.get()
                            Log.i("http-ejemplo", "Exito ${jsonStringUsuario}")

                            val estudiante: Usuario? = Klaxon()
                                    .parse<Usuario>(jsonStringUsuario)

                            if (estudiante != null) {
                                val idEstudiante: TextView = findViewById(R.id.id_Estudiante)
                                val nombreEstudiante: TextView = findViewById(R.id.nombre)
                                val apellidoEstudiante: TextView = findViewById(R.id.apellidos)
                                val fechaNacimiento: TextView = findViewById(R.id.fechaNacimiento)
                                val semestreActual: TextView = findViewById(R.id.semestreActual)
                                val graduado: TextView = findViewById(R.id.graduado)
                                idEstudiante.text = (estudiante.idEstudiante.toString())
                                nombreEstudiante.text = (estudiante.nombres)
                                apellidoEstudiante.text = (estudiante.apellidos)
                                fechaNacimiento.text = (estudiante.fechaNacimiento)
                                semestreActual.text = (estudiante.semestreActual.toString())
                                graduado.text = (estudiante.graduado)
                                Log.i("http-ejemplo", "Nombre: ${estudiante.nombres}")
                                Log.i("http-ejemplo", "Apellido: ${estudiante.apellidos}")
                                Log.i("http-ejemplo", "Id: ${estudiante.id}")
                                Log.i("http-ejemplo", "Fecha Nacimiento: ${estudiante.fechaNacimiento}")
                                Log.i("http-ejemplo", "Semestre Actual: ${estudiante.semestreActual}")
                                Log.i("http-ejemplo", "Graduado: ${estudiante.graduado}")
                                Log.i("http-ejemplo", "Creado: ${estudiante.createdAtDate}")
                                Log.i("http-ejemplo", "Actualizado: ${estudiante.updatedAtDate}")

                                estudiante.materias.forEach { materia: Materia ->
                                    Log.i("http-ejemplo", "Codigo ${materia.codigo}")
                                    Log.i("http-ejemplo", "Descripcion ${materia.descripcion}")
                                    Log.i("http-ejemplo", "Activo ${materia.activo}")
                                }


                            } else {
                                Log.i("http-ejemplo", "Estudiante nulo")
                            }


                        }
                    }

                }

    }

    private fun registrarReserva() {
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


        val httpRequest = Fuel.post("http://172.31.104.18:1337/Usuarios").body(json.toString())
        httpRequest.headers["Content-Type"] = "application/json"
        httpRequest.response { request, response, result ->

            Log.i("mensaje", request.toString())

            Log.i("mensaje", response.toString())

            Log.i("mensaje", result.toString())
        }

        val intent = Intent (this, MainActivity::class.java)
        finish()
        startActivity(intent)


    }*/

    class Reserva(var idReserva: Int,
                  var idUsuario: Int,
                  var fecha_ini: String,
                  var fecha_fin: String,
                  var createdAt: Long,
                  var updatedAt: Long,
                  var id: Int,
                  var detalles_reservas: List<Detalle_Reservas.Detalle_Reserva>) : Parcelable {
        var createdAtDate = Date(updatedAt)

        var updatedAtDate = Date(createdAt)

        constructor(source: Parcel) : this(
                source.readInt(),
                source.readInt(),
                source.readString(),
                source.readString(),
                source.readLong(),
                source.readLong(),
                source.readInt(),
                source.createTypedArrayList(Detalle_Reservas.Detalle_Reserva.CREATOR)
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
            writeInt(idReserva)
            writeInt(idUsuario)
            writeString(fecha_ini)
            writeString(fecha_fin)
            writeLong(createdAt)
            writeLong(updatedAt)
            writeInt(id)
            writeTypedList(detalles_reservas)
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<Reserva> = object : Parcelable.Creator<Reserva> {
                override fun createFromParcel(source: Parcel): Reserva = Reserva(source)
                override fun newArray(size: Int): Array<Reserva?> = arrayOfNulls(size)
            }
        }
    }
}