package edu.temple.cis3515_assigment_3


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private val arrayImageObject: Array<ImageObject>): RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    private lateinit var myListener: OnItemClickListener
    interface  OnItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        myListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val mangaView = inflater.inflate(R.layout.rcv_itemcontainer,parent,false)
        return ViewHolder(mangaView,myListener)
    }
    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        val manga: ImageObject = arrayImageObject[position]
        val imageViews = holder.imageView
        imageViews.setImageResource(manga.resourceId)

    }
    override fun getItemCount(): Int {
        return arrayImageObject.size
    }

    inner class ViewHolder(itemView: View, listener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.rcvImageView)
        init{
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}

