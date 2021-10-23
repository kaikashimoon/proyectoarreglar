package com.krmen.project.menu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.krmen.project.R
import com.krmen.project.fragments.*
import com.krmen.project.questionnairesNotes.exercisePiano.tutorialExerciseOneActivity

class navBarIntentoNotes : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas_menu_intento)
        drawerLayout = findViewById(R.id.drawerLayout1)
        val navView: NavigationView = findViewById(R.id.nav_vie)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setToolBarTitle("Notas")
        replaceFragment(fragmentNotes())

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when (it.itemId) {

                R.id.nav_menu -> {
                    setToolBarTitle("Inicio")
                    replaceFragment(fragmentNavBar())
                }
                R.id.nav_instrumentos -> {
                    setToolBarTitle("Instrumentos")
                    replaceFragment(fragmentInstruments())
                }
                R.id.nav_teoria -> {
                    setToolBarTitle("Teoría musical")
                    replaceFragment(fragmentMusicalTheory())
                }
                R.id.nav_acerca -> {
                    setToolBarTitle("Acerca de")
                    replaceFragment(fragmentAboutApp())
                }
                R.id.nav_instrucciones -> {
                    setToolBarTitle("Instrucciones")
                    replaceFragment(fragmentInstructions())
                }

                R.id.nav_notas -> {
                    setToolBarTitle("Notas")
                    replaceFragment(fragmentNotes())
                }
                R.id.nav_intervalos -> {
                    setToolBarTitle("Intervalos")
                    replaceFragment(fragmentIntervals())
                }
                R.id.nav_acordes -> {
                    setToolBarTitle("Acordes")
                    replaceFragment(fragmentChord())
                }
                R.id.nav_escalas -> {
                    setToolBarTitle("Escalas")
                    replaceFragment(fragmentScale())
                }

                R.id.nav_configuracion -> {
                    setToolBarTitle("Configuración")
                    replaceFragment(fragmentSetting())
                }

                R.id.nav_salir -> Toast.makeText(applicationContext, "Salir", Toast.LENGTH_SHORT)
                    .show()
            }

            true

        }

    }

    fun setToolBarTitle(title: String) {
        supportActionBar?.title = title
    }

    fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout1, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {

            return true

        }
        return super.onOptionsItemSelected(item)
    }


}