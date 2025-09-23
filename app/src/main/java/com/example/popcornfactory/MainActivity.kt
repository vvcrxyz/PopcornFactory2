package com.example.popcornfactory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var adapter: PeliculaAdapter? = null
    private var peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)

        // Encontrar el GridView y asignarle el adapter
        val gridView = findViewById<GridView>(R.id.gridview)
        gridView.adapter = adapter
    }

    private fun cargarPeliculas() {
        peliculas.add(Pelicula("Big Hero 6", R.drawable.bighero6, R.drawable.headerbighero6,
            "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends..."))

        peliculas.add(Pelicula("1917", R.drawable.n1917, R.drawable.n1917header,
            "British trenches somewhere in France. World war has been going on for the third year..."))

        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader,
            "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day..."))

        peliculas.add(Pelicula("Men in Black", R.drawable.mib, R.drawable.mibheader,
            "Unbeknownst to other people, there is a private agency code named MiB..."))

        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader,
            "Toy Story is about the 'secret life of toys' when people are not around..."))

        peliculas.add(Pelicula("Inception", R.drawable.inception, R.drawable.inceptionheader,
            "Dom Cobb is a skilled thief, the best in the dangerous art of extraction..."))

        // SERIES
        peliculas.add(Pelicula("Dr. House", R.drawable.drhouse, R.drawable.househeader,
            "The series follows the life of anti-social, witty and arrogant medical doctor Gregory House..."))

        peliculas.add(Pelicula("Smallville", R.drawable.smallville, R.drawable.smallvilleheader,
            "The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions..."))

        peliculas.add(Pelicula("Dr. Who", R.drawable.drwho, R.drawable.drwhoheader,
            "Traveling across time and space, the immortal time-lord known as 'The Doctor'..."))

        peliculas.add(Pelicula("Bones", R.drawable.bones, R.drawable.bonesheader,
            "Dr. Temperance Brennan is a brilliant anthropologist who helps the FBI solve crimes..."))

        peliculas.add(Pelicula("Suits", R.drawable.suits, R.drawable.suitsheader,
            "While running from a drug deal gone bad, Mike Ross slips into a job interview..."))

        peliculas.add(Pelicula("Friends", R.drawable.friends, R.drawable.friendsheader,
            "Rachel, Ross, Monica, Joey, Chandler and Phoebe are six friends living in New York City..."))
    }

    class PeliculaAdapter(private val context: Context, private val peliculas: ArrayList<Pelicula>) : BaseAdapter() {

        override fun getCount(): Int = peliculas.size

        override fun getItem(position: Int): Any = peliculas[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val pelicula = peliculas[position]
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val vista = convertView ?: inflater.inflate(R.layout.pelicula, parent, false)

            // Encontrar los views
            val ivPelicula = vista.findViewById<ImageView>(R.id.iv_pelicula)
            val tvNombrePelicula = vista.findViewById<TextView>(R.id.iv_nombre_pelicula)

            ivPelicula.setImageResource(pelicula.image)
            tvNombrePelicula.text = pelicula.titulo

            ivPelicula.setOnClickListener {
                val intent = Intent(context, DetallePelicula::class.java)
                intent.putExtra("titulo", pelicula.titulo)
                intent.putExtra("image", pelicula.image)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                context.startActivity(intent)
            }

            return vista
        }
    }
}
