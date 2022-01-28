package edu.unicauca.payanmapsprototipe

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.unicauca.payanmapsprototipe.databinding.ActivityMainMenuBinding
import kotlinx.android.synthetic.main.activity_gastronomy.*
import kotlinx.android.synthetic.main.activity_gastronomy.btnBack
import kotlinx.android.synthetic.main.activity_tourism.*
import kotlinx.android.synthetic.main.layout_gastronomy.*

class GastronomyActivity : AppCompatActivity() {

    //lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastronomy)

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // -------- LAYOUTS --------
        btnRes.setOnClickListener {
            replaceFragment(FragmentGRestaurants())
            //displayLayout("restaurant")
        }

        btnTypMeals.setOnClickListener {
            replaceFragment(FragmentGTipicalMeals())
            //displayLayout("typicalMeals")
        }
    }

    private fun displayLayout(layout : String) {
        if (layout == "restaurant") {
            setContentView(R.layout.layout_gastronomy)
        }
        else if (layout == "typicalMeals") {
            setContentView(R.layout.layout_gastronomy)
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentsConteiner, fragment)
        fragmentTransaction.commit()
    }

}