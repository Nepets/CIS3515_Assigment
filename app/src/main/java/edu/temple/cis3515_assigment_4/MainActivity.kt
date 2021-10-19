package edu.temple.cis3515_assigment_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //private lateinit var selectionFrag: SelectionFragment
    //private lateinit var displayFrag: DisplayFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mangaNames = resources.getStringArray(R.array.manga_names)
        val mangaImage: IntArray = intArrayOf(R.drawable.blackclover,R.drawable.chainsawman,
            R.drawable.demonslayer,R.drawable.drstone,R.drawable.dragonball,R.drawable.haikyuu,
            R.drawable.juju,R.drawable.onepunch, R.drawable.seraphend,R.drawable.magi,R.drawable.naruto,
            R.drawable.boruto)

        //selectionFrag = SelectionFragment.newInstance(mangaNames,mangaImage)
        //displayFrag =
        supportFragmentManager.beginTransaction()
            .add(R.id.frgContainer1, SelectionFragment.newInstance(mangaNames,mangaImage))
            .add(R.id.frgContainer2,DisplayFragment())
            .commit()

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


}