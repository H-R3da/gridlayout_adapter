package com.example.mediaplayer1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    val arrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val adaptor = Adaptor(this,fetchData(),mediaPlayer)
        recyclerView.layoutManager = GridLayoutManager(this,4)
        recyclerView.adapter = adaptor
    }

    private fun fetchData() : ArrayList<String> {
        val fields: Array<Field> = R.raw::class.java.fields
        var item = mutableListOf<String>()

        for (i in 0 until 30) {
            item.add(fields[i-((i/4).toInt()*4)].name)
        }

        var item2 = item.filter{ s -> s.startsWith("dizzydros")}

        return item2
    }
}