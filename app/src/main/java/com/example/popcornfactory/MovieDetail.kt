package com.example.popcornfactory

import android.R.attr.id
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.popcornfactory.databinding.ActivityMovieDetailBinding


class MovieDetail : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null) {
            val ns = bundle.getInt("numberSeats", 0)
            val id = bundle.getInt("pos", -1)
            val title = bundle.getString("titulo", "")
            val sinopsis = bundle.getString("sinopsis", "")
            val header = bundle.getInt("header", 0)

            binding.movieHeader.setImageResource(header)
            binding.movieTitleDetail.text = title
            binding.movieSummary.text = sinopsis
            binding.seatsLeft.text = "$ns seats available"

            if (ns == 0) {
                binding.buyTickets.isEnabled = false
            } else {
                binding.buyTickets.setOnClickListener {
                    val intent = Intent(this, SeatSelection::class.java)
                    intent.putExtra("id", id)
                    intent.putExtra("titulo", title)
                    startActivity(intent)
                }
            }
        }
    }
}