package edu.temple.cis3515_assigment_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class DisplayFragment : Fragment() {

    private lateinit var layout: View
    private lateinit var model: ImageModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        layout =inflater.inflate(R.layout.fragment_display, container, false)
        model= ViewModelProvider(requireActivity()).get(ImageModel::class.java)
        val textView = layout.findViewById<TextView>(R.id.DisaplyFragTV)
        val imageView = layout.findViewById<ImageView>(R.id.DisplayFragImage)
        model.mangaDescription.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                textView.text = o!!.toString()
            }
        })
        model.mangaImage.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                imageView.setImageResource(o!! as Int)
            }
        })
        //Toast.makeText(layout.context, model.mangaDescription.value.toString(), Toast.LENGTH_LONG).show()

        return layout
    }

}