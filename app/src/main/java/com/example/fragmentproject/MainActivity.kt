package com.example.fragmentproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageFragment = FragmentClass()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frameLayout, messageFragment)
            .addToBackStack("previous Fragment")
            .commit()

        val colors = resources.getStringArray(R.array.colors)
        val spinner = findViewById<Spinner>(R.id.spinner)
        var color = colors[0]

        if (spinner != null) {
            spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    color = colors[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    color = "white"
                }
            }
        }

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frameLayout, Fragment2Class().newInstance(color))
                .addToBackStack("ColorFragment")
                .commit()
        }
    }



    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 0) super.onBackPressed()
        else supportFragmentManager.popBackStack()
    }
}