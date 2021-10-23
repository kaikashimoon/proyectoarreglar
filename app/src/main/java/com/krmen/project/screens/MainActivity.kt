package com.krmen.project.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krmen.project.menu.navBar
import com.krmen.project.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pasar a la pantalla de registro
        buttonRegistro.setOnClickListener {

        }

        //Pasa a la pantalla de olvido su contraseña
        textOlvidoContra.setOnClickListener {

        }

        buttonIniciarSesion.setOnClickListener {
            startActivity(Intent( this, navBar::class.java ))
        }

    }
}