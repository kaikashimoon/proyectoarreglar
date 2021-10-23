package com.krmen.project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.krmen.project.R

class mainAdapter(private val instruList : ArrayList<Instru>) : RecyclerView.Adapter<mainAdapter.ViewHolder>() {


    private lateinit var mListener : onItemClickList

    interface onItemClickList{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClickList){

        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.items_instrumentos,
            parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = instruList[position]
        holder.titleIm.setImageResource(currentItem.titleIm)
        holder.tvHead.text = currentItem.head


    }

    override fun getItemCount(): Int {

        return instruList.size
    }

    class ViewHolder(itemView : View, listener: onItemClickList) : RecyclerView.ViewHolder(itemView){

        val titleIm : ShapeableImageView = itemView.findViewById(R.id.title_im)
        val tvHead : TextView = itemView.findViewById(R.id.tvHead)


        init {

            itemView.setOnClickListener {

                listener.onItemClick(absoluteAdapterPosition)
            }

        }

    }

}