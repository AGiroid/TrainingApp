package com.example.trainingapp.a.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.trainingapp.R


class ResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        val name = view.findViewById<TextView>(R.id.name)
        val age = view.findViewById<TextView>(R.id.age)
        val dob = view.findViewById<TextView>(R.id.dob)
        val sharedPreferences = activity?.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        name.text = sharedPreferences?.getString("name", "")
        age.text = sharedPreferences?.getString("age", "")
        dob.text = sharedPreferences?.getString("dob", "")
        return view
    }

}