package com.carlos.ejemplofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), OnFragmentActionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRed = findViewById<Button>(R.id.btn1)
        var btnBlue = findViewById<Button>(R.id.btn2)
        btnRed.setOnClickListener { replaceFragment(RedFragment()) }
        btnBlue.setOnClickListener { replaceFragment(BlueFragment()) }
    }

    override fun onClickFragmentButton() {
        Toast.makeText(this, "El botón ha sido pulsado", Toast.LENGTH_SHORT).show()
    }

    // funcion para cambiar los fragmentos
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}