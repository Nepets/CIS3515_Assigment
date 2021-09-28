package edu.temple.cis3515_assigment_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    private fun getData(): Array<ImageObject> {
        return arrayOf(ImageObject("Black Clover", R.drawable.blackclover), ImageObject("Chainsaw Man",R.drawable.chainsawman),
            ImageObject("Demon Slayer", R.drawable.demonslayer), ImageObject("Dr. Stone",R.drawable.drstone),
            ImageObject("Dragon Ball Z",R.drawable.dragonball), ImageObject("Haikyuu",R.drawable.haikyuu),
            ImageObject("One Piece",R.drawable.juju), ImageObject("One Punch",R.drawable.onepunch), ImageObject("Seraph no End", R.drawable.seraphend))

    }

}