package com.example.fragmentproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment2Class(): Fragment() {
    companion object {
        private val KEY_COLOR = "some_color"
    }
    fun newInstance(color:String): Fragment2Class {
        val fragment = Fragment2Class()
        val args: Bundle = Bundle()
        args.putString(KEY_COLOR, color)
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment2_layout, container, false)
        return view
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val color = when (arguments?.getString(KEY_COLOR)) {
            "pink" -> resources.getDrawable(R.color.pink)
            "red" -> resources.getDrawable(R.color.red)
            "blue" -> resources.getDrawable(R.color.blue)
            "yellow" -> resources.getDrawable(R.color.yellow)
            "green" -> resources.getDrawable(R.color.green)
            else -> {resources.getDrawable(R.color.white)}
        }
        view.findViewById<View>(R.id.fragment2).background = color
    }
}