package com.dicoding.myapp_videogame

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListVideoGameAdapter (private val listVideoGame: ArrayList<VideoGames>) : RecyclerView.Adapter<ListVideoGameAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_vgame, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listVideoGame.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val videogames = listVideoGame[position]
        holder.imgPhoto.setImageResource(videogames.photo)
        holder.tvName.text = videogames.name
        holder.tvDescription.text = videogames.description
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, VideoGameDetails::class.java)
            intent.putExtra(VideoGameDetails.EXTRA_VGAMES, videogames)
            holder.itemView.context.startActivity(intent)
        }
    }
}