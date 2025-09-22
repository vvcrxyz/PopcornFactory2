package com.example.popcornfactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity



class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)


        val bundle = intent.extras

        if(bundle != null){
            this.iv_pelicula_imagen.setImageResorce(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getInt("nombre"))
            tv_pelicula_desc.seText(bundle.getInt("sinopsis"))
        }
    }
}