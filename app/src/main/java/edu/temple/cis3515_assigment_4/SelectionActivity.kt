package edu.temple.cis3515_assigment_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.title = resources.getString(R.string.selection_name)
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
        val mangaNames = resources.getStringArray(R.array.manga_names)

        return arrayOf(ImageObject(mangaNames[0], R.drawable.blackclover), ImageObject(mangaNames[1].toString(),R.drawable.chainsawman),
            ImageObject(mangaNames[2], R.drawable.demonslayer), ImageObject(mangaNames[3],R.drawable.drstone),
            ImageObject(mangaNames[4],R.drawable.dragonball), ImageObject(mangaNames[5],R.drawable.haikyuu),
            ImageObject(mangaNames[6],R.drawable.juju), ImageObject(mangaNames[7],R.drawable.onepunch),
            ImageObject(mangaNames[8], R.drawable.seraphend), ImageObject(mangaNames[9],R.drawable.magi),
            ImageObject(mangaNames[10],R.drawable.naruto),ImageObject(mangaNames[11],R.drawable.boruto))

    }

}