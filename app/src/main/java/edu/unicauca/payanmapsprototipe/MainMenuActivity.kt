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

        //-------- MENU AND USER BUTTONS --------
        btnMenu.setOnClickListener {
            toastMessage("Menu")
        }

        btnUser.setOnClickListener {
            toastMessage("User")
        }

        //-------- MAPS --------
        btnMaps.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, MapsActivity::class.java))

            //toastMessage("Maps")
        }

        //-------- TOURISM --------
        btnTourism.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, TourismActivity::class.java))

            //toastMessage("Tourism")
        }

        //-------- GASTRONOMY --------
        btnGastronomy.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, GastronomyActivity_Options::class.java))

            //toastMessage("Gastronomy")
        }

        //-------- HOTEL --------
        btnHotel.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, HotelActivity::class.java))

            //toastMessage("Hotel")
        }

        //-------- MORE --------
        btnMore.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, MoreActivity::class.java))

            //toastMessage("More")
        }

        //-------- EVENTS --------
        btnEvents.setOnClickListener {
            toastMessage("Events")
        }

    }

    fun toastMessage(name_option: String) {
        Toast.makeText(this, "You clicked $name_option", Toast.LENGTH_SHORT).show()
    }
}