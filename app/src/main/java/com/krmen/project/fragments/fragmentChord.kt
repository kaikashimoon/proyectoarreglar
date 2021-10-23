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
import com.krmen.project.adapters.Acord
import com.krmen.project.adapters.adapterChord
import com.krmen.project.instruments.instrumentBass
import com.krmen.project.instruments.instrumentGuitar
import com.krmen.project.instruments.instrumentPiano


class fragmentChord : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var arrayL: ArrayList<Acord>
    lateinit var image: Array<Int>
    lateinit var headerA: Array<String>
    lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_acordes2, container, false)


        image = arrayOf(
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,
            R.drawable.natural,

        )

        headerA = arrayOf(
            "Mayor y menor, notación",
            "Disminuido",
            "Dismininuido, notación",
            "Tríadas",
            "Tríadas, notación",
            "Pentadas",
            "Pentadas, notación"
        )



        recycler = view.findViewById(R.id.recy)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.setHasFixedSize(true)

        arrayL = arrayListOf<Acord>()
        userInfo()


        return view
    }
    private fun userInfo() {

        for (i in image.indices){

            val acord = Acord(image[i],headerA[i])
            arrayL.add(acord)
        }


        var adapter = adapterChord(arrayL)
        recycler.adapter = adapter
        adapter.setOnClickListener(object : adapterChord.onItemChord{
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