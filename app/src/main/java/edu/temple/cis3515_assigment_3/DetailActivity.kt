package edu.temple.cis3515_assigment_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val text = intent?.extras?.getString("name")
        val imageId = intent?.extras?.getInt("image")
        val imageView = findViewById<ImageView>(R.id.displayImageView)
        val textView = findViewById<TextView>(R.id.displayTextView)

        textView.text = text
        textView.textSize = 20F
        imageView.setImageResource(imageId!!)

        findViewById<Button>(R.id.displayButton).setOnClickListener{
            finish()
        }


    }
}