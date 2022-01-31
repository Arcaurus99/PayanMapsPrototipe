package edu.unicauca.payanmapsprototipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_gastronomy_options.*

class GastronomyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastronomy)

        var fragment = intent.getStringExtra(frag)

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }

        if (fragment == "FragmentGRestaurants") {
            replaceFragment(FragmentGRestaurants())
        } else if(fragment == "FragmentGTypicalMeals") {
            replaceFragment(FragmentGTypicalMeals())
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

        /*// -------- LAYOUTS --------
        btnRes.setOnClickListener {
            replaceFragment(FragmentGRestaurants())
            //displayLayout("restaurant")
            //Toast.makeText(this, "Restaurants", Toast.LENGTH_SHORT).show()
        }

        btnTypMeals.setOnClickListener {
            replaceFragment(FragmentGTypicalMeals())
            //displayLayout("typicalMeals")
            //Toast.makeText(this, "TypicalMeals", Toast.LENGTH_SHORT).show()
        }*/
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentsContainer, fragment)
        fragmentTransaction.commit()
    }
}