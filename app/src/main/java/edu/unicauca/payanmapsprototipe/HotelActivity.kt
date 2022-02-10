package edu.unicauca.payanmapsprototipe

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.activity_tourism.*

class HotelActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var hotelRecyclerView: RecyclerView
    private lateinit var hotelArrayList: ArrayList<Hotel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel2)

        hotelRecyclerView = findViewById(R.id.recyclerViewContainer)
        hotelRecyclerView.layoutManager = LinearLayoutManager(this)
        hotelRecyclerView.setHasFixedSize(true)

        hotelArrayList = arrayListOf<Hotel>()
        getHotelData()

        btnBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun getHotelData() {
        dbref = FirebaseDatabase.getInstance().getReference().child("Place").child("Hotel")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (hotelSnapshot in snapshot.children) {
                        val hotel = hotelSnapshot.getValue(Hotel::class.java)
                        hotelArrayList.add(hotel!!)
                    }

                    hotelRecyclerView.adapter = MyAdapter(hotelArrayList)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}