package edu.unicauca.payanmapsprototipe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_gastronomy_options.*

class GastronomyActivity_Options : AppCompatActivity() {

    //lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_gastronomy_options)

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // -------- LAYOUTS --------
        btnRes.setOnClickListener {
            var intent = Intent(this@GastronomyActivity_Options, GastronomyActivity::class.java)
            intent.putExtra("frag","FragmentGRestaurants")
            startActivity(intent)
            //Toast.makeText(this, "Restaurants", Toast.LENGTH_SHORT).show()
        }

        btnTypMeals.setOnClickListener {
            var intent = Intent(this@GastronomyActivity_Options, GastronomyActivity::class.java)
            intent.putExtra("frag","FragmentGTypicalMeals")
            startActivity(intent)
            //Toast.makeText(this, "TypicalMeals", Toast.LENGTH_SHORT).show()
        }
    }

    /*private fun displayLayout(layout : String) {
        if (layout == "restaurant") {
            setContentView(R.layout.activity_gastronomy)
        }
        else if (layout == "typicalMeals") {
            setContentView(R.layout.activity_gastronomy)
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }*/

}