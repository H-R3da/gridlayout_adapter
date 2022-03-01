package com.example.mediaplayer1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

    class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    val arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val adaptor = Adaptor(this,fetchData())
        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.adapter = adaptor
    }

    private fun fetchData() : ArrayList<String> {
        val item = ArrayList<String>()
        for (i in 0 until 30) {
            item.add("$i")
        }
        return item
    }
}