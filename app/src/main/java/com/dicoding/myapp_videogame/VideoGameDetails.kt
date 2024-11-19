package com.dicoding.myapp_videogame

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VideoGameDetails : AppCompatActivity() {

    companion object {
        const val EXTRA_VGAMES = "EXTRA VIDEO GAMES"
    }

    private lateinit var detailPhoto: ImageView
    private lateinit var detailName: TextView
    private lateinit var detailDescription: TextView
    private lateinit var buttonShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_game_details)

        detailPhoto = findViewById(R.id.detail_photo)
        detailName = findViewById(R.id.detail_name)
        detailDescription = findViewById(R.id.detail_description)
        buttonShare = findViewById(R.id.action_share)

        val videogames = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<VideoGames>(EXTRA_VGAMES, VideoGames::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<VideoGames>(EXTRA_VGAMES)
        }
        if (videogames != null) {
            detailPhoto.setImageResource(videogames.photo)
            detailName.text = videogames.name
            detailDescription.text = videogames.description
        }
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = "Video Game Details"

        buttonShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, detailName.text)
                type = "text/plain"
            }
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
