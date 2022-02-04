package edu.unicauca.payanmapsprototipe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_gastronomy_options.*

class GastronomyActivityOptions : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_gastronomy_options)

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // -------- LAYOUTS --------
        btnRes.setOnClickListener {
            val intent = Intent(this@GastronomyActivityOptions, GastronomyActivity::class.java)
            intent.putExtra("frag","GastronomyFragmentRestaurants")
            startActivity(intent)
            //Toast.makeText(this, "Restaurants", Toast.LENGTH_SHORT).show()
        }

        btnTraditionalFoods.setOnClickListener {
            val intent = Intent(this@GastronomyActivityOptions, GastronomyActivity::class.java)
            intent.putExtra("frag","GastronomyFragmentTraditionalFoods")
            startActivity(intent)
            //Toast.makeText(this, "TypicalMeals", Toast.LENGTH_SHORT).show()
        }
    }

}