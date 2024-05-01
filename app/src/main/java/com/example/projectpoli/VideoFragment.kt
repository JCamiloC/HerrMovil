package com.example.projectpoli

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.projectpoli.R

class VideoFragment : Fragment() {

    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_video, container, false)

        // Obtener el VideoView del diseño
        videoView = view.findViewById(R.id.videoView)

        // URL del video a reproducir (puedes cambiarla por la URL de tu video)
        val videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

        // Configurar la URL del video en el VideoView
        val videoUri = Uri.parse(videoUrl)
        videoView.setVideoURI(videoUri)

        // Configurar los controles de reproducción del video
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Iniciar la reproducción del video
        videoView.start()

        return view
    }
}
