package com.example.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intento: Intent = Intent( this, CatalogActivity::class.java)

        var button : Button = findViewById(R.id.boton) as Button

        button.setOnClickListener {
            startActivity(intento)

        }

    }
}