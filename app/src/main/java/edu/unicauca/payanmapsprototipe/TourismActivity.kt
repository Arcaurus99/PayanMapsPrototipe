package edu.unicauca.payanmapsprototipe

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.activity_tourism.*

class TourismActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tourism)

        btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    /*override fun onSupportNavigateUp(): Boolean {
        btnBack.setOnClickListener {
            onBackPressed()
        }
        return true
    }*/
}