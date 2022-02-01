package edu.unicauca.payanmapsprototipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_gastronomy.*
import kotlinx.android.synthetic.main.activity_gastronomy.btnBack

class MoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        // --------- FRAGMENTS ---------
        val fragment = intent.getStringExtra("frag")

        displayFragment(fragment.toString())

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }


        /*

        // -------- SLIDE BAR BUTTONS ---------
        btnRestaurants.setOnClickListener {
            displayFragment("GastronomyFragmentRestaurants")
        }
        btnTraditionalFoods.setOnClickListener {
            displayFragment("GastronomyFragmentTraditionalFoods")
        }

        */

    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentsContainer, fragment)
        fragmentTransaction.commit()
    }

    private fun displayFragment(fragment : String) {

        if (fragment == "MoreFragmentNightclubs") {
            replaceFragment(MoreFragmentNightclubs())
            textTitle.setText(R.string.nightclubs)
            textTitle.setBackgroundResource(R.color.orange_rest)
        } else if(fragment == "MoreFragmentPubs") {
            replaceFragment(MoreFragmentPubs())
            textTitle.setText(R.string.pubs)
            textTitle.setBackgroundResource(R.color.blue_shore)
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

    }
}