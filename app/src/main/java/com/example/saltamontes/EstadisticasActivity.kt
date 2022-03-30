package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.saltamontes.clases.Operaciones

class EstadisticasActivity : AppCompatActivity() {

    var campoProcesados: TextView ?= null
    var campoGanan: TextView ?= null
    var campoPierden: TextView ?= null
    var campoRecuperan: TextView ?= null

    var lista = Operaciones.listaEstudiantes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)
        iniciarComponentes()

        var btnSalir: Button = findViewById(R.id.btn_salir)
        btnSalir.setOnClickListener{salir()}
    }

    private fun iniciarComponentes(){

        var cantidadTotal = lista.size
        var cantidadGanados:Int = totalGanadores()
        var cantidadPerdedores:Int = totalPerdedores()
        var cantidadRecuperacion:Int = totalRecuperacion()

        campoProcesados = findViewById(R.id.textCantProcesados)
        campoGanan = findViewById(R.id.textCantGanan)
        campoPierden = findViewById(R.id.textCantPierden)
        campoRecuperan = findViewById(R.id.textCantRecuperan)

        campoProcesados?.text = "$cantidadTotal"
        campoGanan?.text = "$cantidadGanados"
        campoPierden?.text = "$cantidadPerdedores"
        campoRecuperan?.text = "$cantidadRecuperacion"

    }

    private fun totalRecuperacion(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.resultado.equals("Usted perdió el periodo pero puede recuperar")){
                cantidad =+ 1
            }
        }
        return cantidad
    }

    private fun totalPerdedores(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.resultado.equals("Usted perdió el periodo")){
                cantidad =+ 1
            }
        }
        return cantidad
    }

    private fun totalGanadores(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.resultado.equals("Usted ganó el periodo")){
                cantidad = cantidad + 1
            }
        }
        return cantidad
    }


    private fun salir(){
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}