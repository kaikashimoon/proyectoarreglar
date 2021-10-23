package com.krmen.project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.krmen.project.R

class adapterChord(private val chordList : ArrayList<Acord>) : RecyclerView.Adapter<adapterChord.ViewHolder>() {

    private lateinit var mListener : onItemChord

    interface onItemChord{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemChord){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.items_acordes,
            parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem =chordList [position]
        holder.titleIm.setImageResource(currentItem.titlei)
        holder.tvHead.text = currentItem.hea
    }

    override fun getItemCount(): Int {
        return chordList.size
    }

    class ViewHolder(itemView : View, listener:onItemChord) : RecyclerView.ViewHolder(itemView){

        val titleIm : ShapeableImageView = itemView.findViewById(R.id.tImage)
        val tvHead : TextView = itemView.findViewById(R.id.tvHAcordes)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}