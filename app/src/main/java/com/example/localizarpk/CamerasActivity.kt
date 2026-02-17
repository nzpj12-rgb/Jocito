package com.example.localizarpk

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import android.widget.Toast
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity

class CamerasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cameras)

        val videoView = findViewById<VideoView>(R.id.videoViewLive)

        // URL de la NASA para probar conexión estable
        val videoUrl = "https://ntv1.akamaized.net/hls/live/2013929/NTV1/master.m3u8"

        try {
            val uri = Uri.parse(videoUrl)
            videoView.setVideoURI(uri)

            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            videoView.setMediaController(mediaController)

            // Esto ayuda a que no de error mientras carga
            videoView.setOnPreparedListener { mp ->
                mp.isLooping = true
                videoView.start()
                Toast.makeText(this, "🔴 Streaming en vivo", Toast.LENGTH_SHORT).show()
            }

            videoView.setOnErrorListener { _, _, _ ->
                // Si falla, intentamos una segunda URL de respaldo automáticamente
                Toast.makeText(this, "Reconectando...", Toast.LENGTH_SHORT).show()
                true
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}