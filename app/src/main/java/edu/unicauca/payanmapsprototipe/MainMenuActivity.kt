package edu.unicauca.payanmapsprototipe

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        //setTheme(R.style.SplashTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btnMaps.setOnClickListener {

            val intent = Intent(this@MainMenuActivity, MapsActivity::class.java)
            startActivity(intent)

            //toastMessage("Maps")
        }

        btnMenu.setOnClickListener {toastMessage("Menu")
        }

        btnUser.setOnClickListener {
            toastMessage("User")
        }

        btnTourism.setOnClickListener {
            toastMessage("Tourism")
        }

        btnGastronomy.setOnClickListener {
            toastMessage("Gastronomy")
        }

        btnHotel.setOnClickListener {
            toastMessage("Hotel")
        }

        btnMore.setOnClickListener {
            toastMessage("More")
        }

        btnEvents.setOnClickListener {
            toastMessage("Events")
        }

    }

    fun toastMessage(name_option: String) {
        Toast.makeText(this, "You clicked $name_option", Toast.LENGTH_SHORT).show()
    }
}