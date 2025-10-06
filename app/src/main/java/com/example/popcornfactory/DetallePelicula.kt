package com.example.popcornfactory

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.popcornfactory.databinding.ActivityDetallePeliculaBinding

class DetallePelicula : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if (bundle != null) {
            binding.ivPeliculaImagen.setImageResource(bundle.getInt("header"))
            binding.ivNombrePelicula.text = bundle.getString("nombre")
            binding.ivPeliculaDesc.text = bundle.getString("sinopsis")
        }
    }
}