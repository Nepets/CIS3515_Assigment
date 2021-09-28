package edu.temple.cis3515_assigment_3

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val arrayImageObject: Array<ImageObject>): RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.rcvImageView)
        val textView = itemView.findViewById<TextView>(R.id.rcvDescriptionView)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val mangaView = inflater.inflate(R.layout.rcv_itemcontainer,parent,false)

        return ViewHolder(mangaView)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        val manga: ImageObject = arrayImageObject[position]

        val imageViews = holder.imageView
        val textView = holder.textView
        imageViews.setImageResource(manga.resourceId)
        textView.text = manga.description

    }

    override fun getItemCount(): Int {
        return arrayImageObject.size
    }
}

