package edu.unicauca.payanmapsprototipe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_tourism_options.*

class TourismActivityOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_tourism_options)

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // -------- LAYOUTS --------
        btnEcologicGuide.setOnClickListener {
            val intent = Intent(this@TourismActivityOptions, TourismActivity::class.java)
            intent.putExtra("frag", "TourismFragmentEcoGuides")
            startActivity(intent)
            //Toast.makeText(this, "Nightclubs", Toast.LENGTH_SHORT).show()
        }

        btnCityGuide.setOnClickListener {
            val intent = Intent(this@TourismActivityOptions, TourismActivity::class.java)
            intent.putExtra("frag", "TourismFragmentEcoGuides")
            startActivity(intent)
            //Toast.makeText(this, "Pubs", Toast.LENGTH_SHORT).show()
        }
    }
}