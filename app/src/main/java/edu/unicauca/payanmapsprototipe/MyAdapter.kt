package edu.unicauca.payanmapsprototipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val hotelList : ArrayList<Hotel>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_hotel, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = hotelList[position]

        holder.name.text = currentitem.name
    }

    override fun getItemCount(): Int {
        return hotelList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.txtName)
        //val phone : ImageButton = itemView.findViewById(R.id.btnPhone)
        //val web_page : ImageButton = itemView.findViewById(R.id.btnWeb)

    }
}