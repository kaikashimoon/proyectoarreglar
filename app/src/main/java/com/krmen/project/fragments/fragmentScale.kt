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
import com.krmen.project.adapters.Esca
import com.krmen.project.adapters.adapterScale
import com.krmen.project.instruments.*

class fragmentScale : Fragment() {

    lateinit var nRecyclerView: RecyclerView
    lateinit var nArrayList: ArrayList<Esca>
    lateinit var img: Array<Int>
    lateinit var nHead: Array<String>
    lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_escalas2, container, false)

        img = arrayOf(
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
        )

        nHead = arrayOf(
            "Mayor y menor",
            "Mayor y menor, notación",
            "Escalas menores,",
            "Escalas menores, notación",
            "Pentatónica/blues",
            "Pentatónica/blues, notación",
            "Modos griegos"
        )



        nRecyclerView = view.findViewById(R.id.recyEscalas)
        nRecyclerView.layoutManager = LinearLayoutManager(activity)
        nRecyclerView.setHasFixedSize(true)

        nArrayList = arrayListOf<Esca>()
        dUser()


        return view
    }
    private fun dUser() {

        for (i in img.indices) {

            val esca = Esca(img[i], nHead[i])
            nArrayList.add(esca)
        }


        var adapter = adapterScale(nArrayList)
        nRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : adapterScale.onItemCl {
            override fun onItemClick(position: Int) {
                when (position) {
                    0 -> {
                        intent = Intent(requireActivity(), instrumentPiano::class.java)
                    }

                    1 -> {
                        intent = Intent(requireActivity(), instrumentGuitar::class.java)
                    }

                    2 -> {
                        intent = Intent(requireActivity(), instrumentBass::class.java)
                    }
                    3 -> {
                        intent = Intent(requireActivity(), instrumentFluter::class.java)
                    }
                    4 -> {
                        intent = Intent(requireActivity(), instrumentHarmonica::class.java)
                    }
                    5 -> {
                        intent = Intent(requireActivity(), instrumentFluter::class.java)
                    }

                }
                startActivity(intent)
            }

        })

    }
}