package com.krmen.project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.krmen.project.R

class newAdapter (private val notesList : ArrayList<adaptersNotes>) : RecyclerView.Adapter<newAdapter.ViewHolder>() {


    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener : onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.items_notes,
            parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = notesList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeader.text = currentItem.header


    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class ViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_Image)
        val tvHeader : TextView = itemView.findViewById(R.id.tvHNotas)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}