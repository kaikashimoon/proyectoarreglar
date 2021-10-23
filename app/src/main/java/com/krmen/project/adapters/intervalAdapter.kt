package com.krmen.project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.krmen.project.R

class intervalAdapter(private val intervalList : ArrayList<Interva>) : RecyclerView.Adapter<intervalAdapter.ViewHolder>() {

    private lateinit var mListener : onItemClicked

    interface onItemClicked{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClicked){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.items_intervalos,
            parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = intervalList[position]
        holder.titleIm.setImageResource(currentItem.ti)
        holder.tvHead.text = currentItem.he

    }

    override fun getItemCount(): Int {
        return intervalList.size
    }

    class ViewHolder(itemView : View, listener: onItemClicked) : RecyclerView.ViewHolder(itemView){

        val titleIm : ShapeableImageView = itemView.findViewById(R.id.image_tittle)
        val tvHead : TextView = itemView.findViewById(R.id.tvHIntervalos)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }
}