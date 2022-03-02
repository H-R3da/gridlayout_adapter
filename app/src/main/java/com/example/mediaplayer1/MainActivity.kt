package com.example.mediaplayer1

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val arrayList = ArrayList<String>()
    private val rapperNames = listOf("figoshin", "dizzydros")
    private val rappersData = ArrayList<RapperData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val adaptor = Adaptor(this,fetchData(this ,rapperNames),mediaPlayer)
        recyclerView.layoutManager = GridLayoutManager(this,4)
        recyclerView.adapter = adaptor
    }

    private fun fetchData(context: Context, rapperNames : List<String>) : ArrayList<RapperData> {
        val drawableFields: Array<Field> = R.drawable::class.java.fields
        val drawableLists = drawableFields.map { it.name }.toTypedArray().toList()
        val rawFields: Array<Field> = R.raw::class.java.fields
        val rawLists = rawFields.map { it.name }.toTypedArray().toList()
        var rapperBg : Int?
        var rapperIc : Int?
        var rapperAdlibs : MutableList<String>?


        val rappersData = ArrayList<RapperData>()

        println(drawableLists)
        for (rapperName in rapperNames) {
            rapperBg = context.resources.getIdentifier(drawableLists.filter { s -> s.startsWith("dizzy") }[0],"raw", context.packageName)
            rapperIc = context.resources.getIdentifier(drawableLists.filter { s -> s.startsWith("dizzy") }[0],"raw", context.packageName)
            rapperAdlibs = rawLists.filter { s -> s.startsWith(rapperName)}.toMutableList()

            rappersData.add(RapperData(rapperName,rapperBg,rapperIc,rapperAdlibs))
        }


        return rappersData
    }
}