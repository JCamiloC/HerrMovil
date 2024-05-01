package com.example.projectpoli

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class BotonesFragment : Fragment() {

    private lateinit var buttonInfo: Button
    private lateinit var imageViewProduct: ImageView
    private lateinit var textViewProductInfo: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_botones, container, false)

        // Find views
        buttonInfo = view.findViewById(R.id.buttonInfo)
        imageViewProduct = view.findViewById(R.id.imageViewProduct)
        textViewProductInfo = view.findViewById(R.id.textViewProductInfo)

        // Set click listener for the button
        buttonInfo.setOnClickListener {
            // Toggle visibility of image and text
            imageViewProduct.visibility = if (imageViewProduct.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            textViewProductInfo.visibility = if (textViewProductInfo.visibility == View.VISIBLE) View.GONE else View.VISIBLE

            // Change button text based on visibility
            val buttonText = if (imageViewProduct.visibility == View.VISIBLE) "Ocultar Datos" else "Contactanos"
            buttonInfo.text = buttonText
        }

        return view
    }
}
