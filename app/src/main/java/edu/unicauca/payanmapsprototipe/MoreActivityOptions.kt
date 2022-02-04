package edu.unicauca.payanmapsprototipe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_more_options.*

class MoreActivityOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_more_options)

        // -------- BACK BUTTON --------
        btnBack.setOnClickListener {
            onBackPressed()
        }

        // -------- LAYOUTS --------
        btnNightclubs.setOnClickListener {
            val intent = Intent(this@MoreActivityOptions, MoreActivity::class.java)
            intent.putExtra("frag","MoreFragmentNightclubs")
            startActivity(intent)
            //Toast.makeText(this, "Nightclubs", Toast.LENGTH_SHORT).show()
        }

        btnPubs.setOnClickListener {
            val intent = Intent(this@MoreActivityOptions, MoreActivity::class.java)
            intent.putExtra("frag","MoreFragmentPubs")
            startActivity(intent)
            //Toast.makeText(this, "Pubs", Toast.LENGTH_SHORT).show()
        }

    }
}