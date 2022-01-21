package edu.unicauca.payanmapsprototipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        //setTheme(R.style.SplashTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btnMenu.setOnClickListener {
            toastMessage("Menu")
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

        btnMaps.setOnClickListener {
            toastMessage("Maps")
        }

    }

    fun toastMessage(name_option: String) {
        Toast.makeText(this, "You clicked $name_option", Toast.LENGTH_SHORT).show()
    }
}