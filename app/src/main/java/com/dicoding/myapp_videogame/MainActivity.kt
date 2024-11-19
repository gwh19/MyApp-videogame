package com.dicoding.myapp_videogame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvVideoGames: RecyclerView
    private val list = ArrayList<VideoGames>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvVideoGames = findViewById(R.id.rv_vgames)
        rvVideoGames.setHasFixedSize(true)

        list.addAll(getListVideoGames())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListVideoGames(): ArrayList<VideoGames> {
        val vgName = resources.getStringArray(R.array.data_name)
        val vgDescription = resources.getStringArray(R.array.data_description)
        val vgPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listVideoGames = ArrayList<VideoGames>()
        for(i in vgName.indices) {
            val videogames = VideoGames(vgName[i], vgDescription[i], vgPhoto.getResourceId(i, -1))
            listVideoGames.add(videogames)
        }
        return listVideoGames
    }

    private fun showRecyclerList() {
        rvVideoGames.layoutManager = LinearLayoutManager(this)
        rvVideoGames.adapter = ListVideoGameAdapter(list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}