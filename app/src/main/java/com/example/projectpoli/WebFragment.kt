package com.example.projectpoli

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class WebFragment : Fragment() {

    private lateinit var editTextUrl: EditText
    private lateinit var buttonLoad: Button
    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        // Find views
        editTextUrl = view.findViewById(R.id.editTextUrl)
        buttonLoad = view.findViewById(R.id.buttonLoad)
        webView = view.findViewById(R.id.webView)

        // Configure WebView settings
        webView.webViewClient = WebViewClient()

        // Set button click listener
        buttonLoad.setOnClickListener {
            val url = editTextUrl.text.toString()
            if (url.isNotEmpty()) {
                // Load the URL in the WebView
                webView.loadUrl(url)
            }
        }

        return view
    }
}
