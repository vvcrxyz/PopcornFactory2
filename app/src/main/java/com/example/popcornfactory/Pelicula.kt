package com.example.popcornfactory

data class Pelicula(
    var titulo: String,
    var image: Int,
    var header: Int,
    var sinopsis: String,
    var seats: ArrayList<Cliente>
)