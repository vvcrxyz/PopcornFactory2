package com.example.popcornfactory

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        // Referencias a las vistas
        val ivPeliculaImagen = findViewById<ImageView>(R.id.iv_pelicula_imagen)
        val tvNombrePelicula = findViewById<TextView>(R.id.iv_nombre_pelicula)
        val tvPeliculaDesc = findViewById<TextView>(R.id.iv_pelicula_desc)

        // Recuperar los datos
        val bundle = intent.extras
        if (bundle != null) {
            ivPeliculaImagen.setImageResource(bundle.getInt("header"))
            tvNombrePelicula.text = bundle.getString("titulo")
            tvPeliculaDesc.text = bundle.getString("sinopsis")
        }
    }
}
