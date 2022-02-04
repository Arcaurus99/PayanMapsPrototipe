package edu.unicauca.payanmapsprototipe

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.card_layout_tourism_eco_guides.*

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val db = FirebaseFirestore.getInstance()
    private val data = db.collection("ecologic guide").get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.d(TAG, "${document.id} => ${document.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.d(TAG, "Error getting documents: ", exception)
        }

    private val names = arrayOf(
            "Charcho del Burro",
            "Parque Nacional Purace",
            "Termales",
            "Tierra Adentro",
            "Tour Balboa",
            "Volcan Purace")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout_tourism_eco_guides, viewGroup, false)
        print(data)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        //viewHolder.itemName.text = data[i]
        viewHolder.itemName.text = names[i]

        /*db.collection("ecologic guide").document("termales").get().addOnSuccessListener {
            viewHolder.itemName.text = it.get("Name") as String
        }*/
    }

    override fun getItemCount(): Int {
        //return data.size
        return names.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: FrameLayout = TODO()
        var itemName: TextView

        init {
            itemImage = itemView.findViewById(R.id.frameItem)
            itemName = itemView.findViewById(R.id.txtName)
        }

    }

}