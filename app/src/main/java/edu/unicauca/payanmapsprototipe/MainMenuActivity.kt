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

        btnTourism.setOnClickListener {
            Toast.makeText(this, "You clicked Tourism", Toast.LENGTH_SHORT).show()
        }



    }
}