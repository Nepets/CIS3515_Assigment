package edu.temple.cis3515_assigment_4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val mangaParam1 = "mangaDescription"
private const val mangaParam2 = "mangaImage"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Array<String>? = null
    private var param2: IntArray? = null
    //private lateinit var recycle: RecyclerView
    //private lateinit var model: ImageModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getStringArray(mangaParam1)
            param2 = it.getIntArray(mangaParam2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection2, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycle = view.findViewById<RecyclerView>(R.id.rcvFragView)
        val model= ViewModelProvider(requireActivity()).get(ImageModel::class.java)
        val size = param1?.size
        Log.d("SIZE", size.toString())
        if (size != null) {
            val mangaData = arrayOfNulls<ImageObject>(size)
            for (i in 0 until size) {
                mangaData[i] = ImageObject(param1!![i],param2!![i])
            }
            val adapter = ImageAdapter(mangaData)
            recycle.adapter = adapter
            adapter.setOnItemClickListener(object : ImageAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    //Toast.makeText(layout.context, mangaData[position]!!.description, Toast.LENGTH_LONG).show()
                    model.mangaDescription(mangaData[position]!!.description)
                    model.mangaImage(mangaData[position]!!.resourceId)
                    //Toast.makeText(layout.context, model.mangaDescription.value.toString(), Toast.LENGTH_LONG).show()

                }
            })
            recycle.layoutManager = GridLayoutManager(view.context, 3)
        }

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        @JvmStatic
        fun newInstance(param1: Array<String>, param2: IntArray) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putStringArray(mangaParam1, param1)
                    putIntArray(mangaParam2, param2)
                }
            }
    }
}


