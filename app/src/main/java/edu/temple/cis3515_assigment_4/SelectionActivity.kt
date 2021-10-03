package edu.temple.cis3515_assigment_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mangaData: Array<ImageObject> = getData()
        val recycle = findViewById<RecyclerView>(R.id.rcvView) as RecyclerView
        val detailActivityIntent = Intent(this,DetailActivity::class.java)
        val adapter =ImageAdapter(mangaData)
        recycle.adapter = adapter
        adapter.setOnItemClickListener(object : ImageAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@SelectionActivity, mangaData[position].description.toString(), Toast.LENGTH_LONG).show()
                detailActivityIntent.putExtra("name",mangaData[position].description)
                detailActivityIntent.putExtra("image",mangaData[position].resourceId)
                startActivity(detailActivityIntent)
            }
        })
        recycle.layoutManager = GridLayoutManager(this,3)

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Overriding onRestoreInstanceState() allows you to separate your "initialization" code
        // from your "restoration" code.
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // This method is used to persist state data before the activity is destroyed by Android,
        // allowing it to be retrieved when the activity is recreated.
        // Please items in the Bundle argument and they will be returned when onCreate() and
        // onRestoreInstanceState() are called.
        //
    }

    private fun getData(): Array<ImageObject> {
        return arrayOf(ImageObject("Black Clover", R.drawable.blackclover), ImageObject("Chainsaw Man",R.drawable.chainsawman),
            ImageObject("Demon Slayer", R.drawable.demonslayer), ImageObject("Dr. Stone",R.drawable.drstone),
            ImageObject("Dragon Ball Z",R.drawable.dragonball), ImageObject("Haikyuu",R.drawable.haikyuu),
            ImageObject("One Piece",R.drawable.juju), ImageObject("One Punch",R.drawable.onepunch),
            ImageObject("Seraph no End", R.drawable.seraphend), ImageObject("Magi",R.drawable.magi),
            ImageObject("Naruto",R.drawable.naruto),ImageObject("Boruto",R.drawable.boruto))

    }

}