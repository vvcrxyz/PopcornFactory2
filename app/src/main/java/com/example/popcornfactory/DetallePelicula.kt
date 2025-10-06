package com.example.popcornfactory

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.popcornfactory.

class DetallePelicula : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if (bundle != null) {
            binding.iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            binding.tv_nombre_pelicula.text = bundle.getString("nombre")
            binding.tv_pelicula_desc.text = bundle.getString("sinopsis")
        }
    }
}