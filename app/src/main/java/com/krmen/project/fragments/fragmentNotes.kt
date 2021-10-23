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
import com.krmen.project.adapters.newAdapter
import com.krmen.project.adapters.adaptersNotes
import com.krmen.project.instruments.instrumentBass
import com.krmen.project.instruments.instrumentGuitar
import com.krmen.project.instruments.instrumentPiano
import com.krmen.project.questionnairesNotes.exercisePiano.tutorialExerciseOneActivity

class fragmentNotes : Fragment() {

    lateinit var newRecyclerView: RecyclerView
    lateinit var newAr: ArrayList<adaptersNotes>
    lateinit var ima: Array<Int>
    lateinit var he: Array<String>
    lateinit var intent: Intent


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notas, container, false)

         ima = arrayOf(
             R.drawable.natural,
             R.drawable.natural,
             R.drawable.natural,
             R.drawable.natural,
             R.drawable.natural,
             R.drawable.natural,
             R.drawable.natural,

        )

        he = arrayOf(
            "Naturales",
            "Alteraciones",
            "Naturales, sol",
            "Alteraciones, sol",
            "Naturales, fa",
            "Alteraciones, fa",
            "Clave contralto, do"
            )



        newRecyclerView = view.findViewById(R.id.recyNotas)
        newRecyclerView.layoutManager = LinearLayoutManager(activity)
        newRecyclerView.setHasFixedSize(true)

        newAr = arrayListOf<adaptersNotes>()
        User()


        return view
    }
    private fun User() {

        for (i in ima.indices){

            val notas = adaptersNotes(ima[i],he[i])
            newAr.add(notas)
        }


        var adapter = newAdapter(newAr)
        newRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : newAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                when(position) {
                    0 -> {
                        intent =   Intent(requireActivity(), tutorialExerciseOneActivity::class.java)
                    }

                    1 -> {
                        intent =   Intent(requireActivity(), instrumentPiano::class.java)
                    }

                    2 ->{
                        intent =   Intent(requireActivity(), instrumentPiano::class.java)
                    }
                    3 ->{
                        intent =   Intent(requireActivity(), instrumentPiano::class.java)
                    }
                    4 ->{
                        intent =   Intent(requireActivity(), instrumentPiano::class.java)
                    }
                    5 ->{
                        intent =   Intent(requireActivity(), instrumentPiano::class.java)
                    }
                    6 ->{
                        intent =   Intent(requireActivity(), instrumentGuitar::class.java)
                    }

                }
                startActivity(intent)
            }

        })
    }
    }

