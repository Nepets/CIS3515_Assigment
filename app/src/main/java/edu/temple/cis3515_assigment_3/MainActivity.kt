package edu.temple.cis3515_assigment_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mangaData: Array<ImageObject> = getData()
        val recycle = findViewById<RecyclerView>(R.id.rcvView) as RecyclerView
        var image = findViewById<ImageView>(R.id.mainImageView)
        var text = findViewById<TextView>(R.id.maintextView)
        var adapter =ImageAdapter(mangaData)
        recycle.adapter = adapter
        adapter.setOnItemClickListener(object : ImageAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "$position",Toast.LENGTH_LONG).show()
                image.setImageResource(mangaData[position].resourceId)
                text.text = mangaData[position].description
            }
        })
        recycle.layoutManager = GridLayoutManager(this,4)


    }

    private fun getData(): Array<ImageObject> {
        return arrayOf(ImageObject("Black Clover", R.drawable.blackclover), ImageObject("Chainsaw Man",R.drawable.chainsawman),
            ImageObject("Demon Slayer", R.drawable.demonslayer), ImageObject("Dr. Stone",R.drawable.drstone),
            ImageObject("Dragon Ball Z",R.drawable.dragonball), ImageObject("Haikyuu",R.drawable.haikyuu),
            ImageObject("One Piece",R.drawable.juju), ImageObject("One Punch",R.drawable.onepunch), ImageObject("Seraph no End", R.drawable.seraphend))

    }

}