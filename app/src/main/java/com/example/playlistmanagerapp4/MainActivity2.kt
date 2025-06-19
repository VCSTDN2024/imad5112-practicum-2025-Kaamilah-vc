package com.example.playlistmanagerapp4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val txtList = findViewById<TextView>(R.id.txtList)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val titles = intent.getStringArrayListExtra(" Cruel Summer, God's Plan, Halo, Blinding Lights") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("Taylor Swift, Drake, Beyoncé, The Weeknd") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("3, 4, 5, 4") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("") ?: arrayListOf()

        val output = StringBuilder()
        for (i in titles.indices) {
            output.append("${titles[i]} - ${artists[i]}\nRating: ${ratings[i]} | Comment: ${comments[i]}\n\n")
        }

        txtList.text = output.toString()

        btnAverage.setOnClickListener {
            val avg = if (ratings.isNotEmpty()) ratings.sum().toDouble() / ratings.size else 0.0
            txtAverage.text = "Average: %.2f".format(avg)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}