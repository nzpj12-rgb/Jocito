package com.example.localizarpk

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val seekBar = findViewById<SeekBar>(R.id.seekBarProximidad)
        val tvDistancia = findViewById<TextView>(R.id.tvDistanciaConfig)
        val btnTest = findViewById<Button>(R.id.btnTestAlarma)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvDistancia.text = "Desbloqueo automático a: $progress metros"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        btnTest.setOnClickListener {
            reproducirSirena()
        }
    }

    private fun reproducirSirena() {
        // Detener si ya estaba sonando
        mediaPlayer?.stop()
        mediaPlayer?.release()

        // Crear y reproducir el sonido desde res/raw/sirena_alerta.mp3
        mediaPlayer = MediaPlayer.create(this, R.raw.sirena_alerta)
        mediaPlayer?.start()

        Toast.makeText(this, "📢 Sirena activada en el vehículo", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}