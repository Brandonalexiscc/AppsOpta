package com.example.clase18_nov

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //url de las imagenes
        val img1= "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAsXb2ywro-gnQtbSSYD5KENBBH2lk0DIqjA&s"
        val img2 = "https://i.pinimg.com/550x/74/bb/34/74bb340ffe87e31837a04a538f1bbc10.jpg"
        val img3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhLrq4s4xwmnVwnLBDcBPH7CZY4SSto1DoDA&s"
        val urlList = listOf(img1,img2,img3)
        val img=findViewById<ImageView>(R.id.miImageView)
        Picasso.get().load(img2).into(img)

        val  imagenes=listOf("patricio","bob","calamardo")
        val lvimg = findViewById<ListView>(R.id.miListView)
        lvimg.adapter=ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,imagenes)

        lvimg.setOnItemClickListener { parent, view, position, id ->
            Picasso.get().load(urlList[position]).into(img)
            Toast.makeText(this, "Seleccionaste la imagen ${imagenes[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}