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
import com.krmen.project.adapters.Instru
import com.krmen.project.adapters.mainAdapter
import com.krmen.project.instruments.*


class fragmentInstruments : Fragment() {


    lateinit var newRecycler: RecyclerView
    lateinit var newArray: ArrayList<Instru>
    lateinit var imageI: Array<Int>
    lateinit var head: Array<String>
    lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_instrumentos, container, false)

        imageI = arrayOf(
            R.drawable.piano,
            R.drawable.guitar,
            R.drawable.bass,
            R.drawable.flute,
            R.drawable.harmonica
        )

        head = arrayOf(
            "Piano",
            "Guitarra",
            "Bajo",
            "Flauta",
            "Armonica"
        )



        newRecycler = view.findViewById(R.id.recyInstru)
        newRecycler.layoutManager = LinearLayoutManager(activity)
        newRecycler.setHasFixedSize(true)

        newArray = arrayListOf<Instru>()
        dataUser()


        return view
    }
    private fun dataUser() {

        for (i in imageI.indices){

            val instru = Instru(imageI[i],head[i])
            newArray.add(instru)
        }


        var adapter = mainAdapter(newArray)
        newRecycler.adapter = adapter
        adapter.setOnClickListener(object : mainAdapter.onItemClickList{
            override fun onItemClick(position: Int) {
                when(position) {
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
                        intent =   Intent(requireActivity(), instrumentFluter::class.java)
                    }
                    4 ->{
                        intent =   Intent(requireActivity(), instrumentHarmonica::class.java)
                    }

                }
                startActivity(intent)
            }

        })
}

}














