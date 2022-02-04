package edu.unicauca.payanmapsprototipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_tourism.*
import kotlinx.android.synthetic.main.activity_tourism.btnBack
import kotlinx.android.synthetic.main.layout_tourism_options.*

class TourismActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourism)

        // --------- FRAGMENTS ---------
        val fragment = intent.getStringExtra("frag")

        displayFragment(fragment.toString())

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // -------- SLIDE BAR BUTTONS ---------
        btnEcoGuides.setOnClickListener {
            displayFragment("TourismFragmentEcoGuides")
        }
        btnCityGuides.setOnClickListener {
            displayFragment("TourismFragmentCityGuides")
        }

    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentsContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun displayFragment(fragment : String) {

        if (fragment == "TourismFragmentEcoGuides") {
            replaceFragment(TourismFragmentEcoGuides())
            textTitle.setText(R.string.ecoGuide)
            textTitle.setBackgroundResource(R.color.orange_rest)
        } else if(fragment == "TourismFragmentCityGuides") {
            replaceFragment(TourismFragmentCityGuides())
            textTitle.setText(R.string.cityGuide)
            textTitle.setBackgroundResource(R.color.blue_shore)
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

    }
}