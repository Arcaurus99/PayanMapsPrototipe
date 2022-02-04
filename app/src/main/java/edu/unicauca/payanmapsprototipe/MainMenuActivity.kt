package edu.unicauca.payanmapsprototipe

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_menu.*

enum class ProviderType {
    BASIC
}

class MainMenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {

        //setTheme(R.style.SplashTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // SETUP
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

        //-------- MENU AND USER BUTTONS --------
        btnMenu.setOnClickListener {
            toastMessage("Menu")
        }

        btnUser.setOnClickListener {
            //email?.ifEmpty {
                startActivity(Intent(this@MainMenuActivity, AuthActivity::class.java))
            /*}
            if (email != "") {
                val homeIntent = Intent(this, AuthSingUpActivity::class.java).apply {
                    putExtra("email", email)
                    putExtra("provider", provider)
                }
                startActivity(homeIntent)
            }*/

            //toastMessage("User")
        }

        //-------- MAPS --------
        btnMaps.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, MapsActivity::class.java))
            //toastMessage("Maps")
        }

        //-------- TOURISM --------
        btnTourism.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, TourismActivityOptions::class.java))
            //toastMessage("Tourism")
        }

        //-------- GASTRONOMY --------
        btnGastronomy.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, GastronomyActivityOptions::class.java))
            //toastMessage("Gastronomy")
        }

        //-------- HOTEL --------
        btnHotel.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, HotelActivity::class.java))
            //toastMessage("Hotel")
        }

        //-------- MORE --------
        btnMore.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, MoreActivityOptions::class.java))
            //toastMessage("More")
        }

        //-------- EVENTS --------
        btnEvents.setOnClickListener {
            toastMessage("Events")
        }

    }

    private fun setup(email: String, provider: String) {
        title = "Inicio"
        // THIS SHOULD BE IN AUTH SIGN UP ACTIVITY AS IN THE VIDEO SHOW LIKE HOME
        /*
        txtEmail.text = email
        txtPassword.text = provider

        btnLogOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
        */
    }

    fun toastMessage(name_option: String) {
        Toast.makeText(this, "You clicked $name_option", Toast.LENGTH_SHORT).show()
    }
}