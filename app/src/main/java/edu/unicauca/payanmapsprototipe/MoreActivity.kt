package edu.unicauca.payanmapsprototipe

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_gastronomy.*
import kotlinx.android.synthetic.main.activity_gastronomy.btnBack
import kotlinx.android.synthetic.main.activity_tourism.*

class MoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}