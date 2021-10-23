package com.krmen.project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.krmen.project.R

class adapterScale (private val scaleList : ArrayList<Esca>) : RecyclerView.Adapter<adapterScale.ViewHolder>() {

    private lateinit var mListener : onItemCl

    interface onItemCl{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemCl){

        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.items_escalas,
            parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = scaleList[position]
        holder.titleIm.setImageResource(currentItem.titl)
        holder.tvHead.text = currentItem.headerAe


    }

    override fun getItemCount(): Int {

        return scaleList.size
    }

    class ViewHolder(itemView : View, listener: onItemCl) : RecyclerView.ViewHolder(itemView){

        val titleIm : ShapeableImageView = itemView.findViewById(R.id.tiImage)
        val tvHead : TextView = itemView.findViewById(R.id.tvEscalas)


        init {

            itemView.setOnClickListener {

                listener.onItemClick(absoluteAdapterPosition)
            }

        }

    }
}