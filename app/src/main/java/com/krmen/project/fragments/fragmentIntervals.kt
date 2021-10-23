package com.krmen.project.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krmen.project.R
import com.krmen.project.adapters.Interva
import com.krmen.project.adapters.intervalAdapter
import com.krmen.project.instruments.instrumentBass
import com.krmen.project.instruments.instrumentGuitar
import com.krmen.project.instruments.instrumentPiano


class fragmentIntervals : Fragment() {

    lateinit var newRecyclerView: RecyclerView
    lateinit var newArray: ArrayList<Interva>
    lateinit var imageI: Array<Int>
    lateinit var head: Array<String>
    lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_intervalos2, container, false)

        imageI = arrayOf(
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,

        )

        head = arrayOf(
            "Notación",
            "II y III",
            "II Y III, notación",
            "IV y V",
            "IV y V, notación",
            "VI, VII y VIII",
            "VI, VII Y VIII, notación",
        )



        newRecyclerView = view.findViewById(R.id.recyIntervalos)
        newRecyclerView.layoutManager = LinearLayoutManager(activity)
        newRecyclerView.setHasFixedSize(true)

        newArray = arrayListOf<Interva>()
        dataUser()


        return view
    }
    private fun dataUser() {

        for (i in imageI.indices){

            val interval= Interva(imageI[i],head[i])
            newArray.add(interval)
        }


        var adapter = intervalAdapter(newArray)
        newRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : intervalAdapter.onItemClicked {
            override fun onItemClick(position: Int) {
                when (position) {
                    0 -> {
                        intent =   Intent(requireActivity(), instrumentPiano::class.java)
                    }

                    1 -> {
                        intent =   Intent(requireActivity(), instrumentGuitar::class.java)
                    }

                    2 ->{
                        intent =   Intent(requireActivity(), instrumentBass::class.java)
                    }

                    3 ->{
                        intent =   Intent(requireActivity(), instrumentBass::class.java)
                    }
                    4 ->{
                        intent =   Intent(requireActivity(), instrumentBass::class.java)
                    }
                    5 ->{
                        intent =   Intent(requireActivity(), instrumentBass::class.java)
                    }
                    6 ->{
                        intent =   Intent(requireActivity(), instrumentBass::class.java)
                    }
                }
                startActivity(intent)
            }
        })

    }
}