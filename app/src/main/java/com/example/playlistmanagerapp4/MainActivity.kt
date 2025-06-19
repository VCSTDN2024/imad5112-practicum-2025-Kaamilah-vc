package com.example.playlistmanagerapp4


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val titles = arrayListOf(
        "Cruel Summer", "God's Plan", "Halo", "Blinding Lights"
    )

    private val artists = arrayListOf(
        "Taylor Swift", "Drake", "Beyoncé", "The Weeknd"
    )

    private val ratings = arrayListOf(3, 4, 5, 4)

    private val comments = arrayListOf(
        "Amazing",
        "Great beat and flow.",
        "Iconic vocals!",
        "Love the vibe."
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtTitle = findViewById<EditText>(R.id.songtitle)
        val edtArtist = findViewById<EditText>(R.id.artistname)
        val edtRating = findViewById<EditText>(R.id.Rating)
        val Comment = findViewById<EditText>(R.id.atcomment)
        val btnAdd = findViewById<Button>(R.id.btnAddSong)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAdd.setOnClickListener {
            val title = edtTitle.text.toString()
            val artist = edtArtist.text.toString()
            val rating = edtRating.text.toString().toIntOrNull()
            val comment = Comment.text.toString()

            if (title.isEmpty() || artist.isEmpty() || rating == null || rating !in 1..5 || comment.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields correctly.", Toast.LENGTH_SHORT).show()
            } else if (titles.size >= 8) {
                Toast.makeText(this, "Playlist without space (max 8 songs)", Toast.LENGTH_SHORT).show()
            } else {
                titles.add(title)
                artists.add(artist)
                ratings.add(rating)
                comments.add(comment)
                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()

                edtTitle.text.clear()
                edtArtist.text.clear()
                edtRating.text.clear()
                Comment.text.clear()
            }
        }

        btnDetails.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putStringArrayListExtra("titles", titles)
                putStringArrayListExtra("artists", artists)
                putIntegerArrayListExtra("ratings", ArrayList(ratings))
                putStringArrayListExtra("comments", comments)
            }
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}