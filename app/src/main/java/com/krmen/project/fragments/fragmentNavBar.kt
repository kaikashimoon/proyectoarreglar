package com.krmen.project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krmen.project.R
import kotlinx.android.synthetic.main.fragment_men.view.*

class fragmentNavBar : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_men, container, false)

        view.cardNotas.setOnClickListener{
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.menuFrag, fragmentNotes())
                .addToBackStack(null)
                .commit()

        }
        view.cardIntervalos.setOnClickListener{
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.menuFrag, fragmentScale())
                .addToBackStack(null)
                .commit()

        }
        view.cardAcordes.setOnClickListener{
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.menuFrag, fragmentIntervals())
                .addToBackStack(null)
                .commit()

        }

        view.cardEscalas.setOnClickListener{
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.menuFrag, fragmentIntervals())
                .addToBackStack(null)
                .commit()

        }

        view.cardInstrumentos.setOnClickListener{
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.menuFrag, fragmentInstruments())
                .addToBackStack(null)
                .commit()

        }

        return view

    }

}

