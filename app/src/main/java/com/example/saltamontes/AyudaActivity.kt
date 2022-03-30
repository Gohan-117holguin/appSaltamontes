package com.example.saltamontes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AyudaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        var botonSalir: Button =findViewById(R.id.btn_salirAyu)
        botonSalir.setOnClickListener{salir()}
    }

    private fun salir(){
        finish()
    }
}