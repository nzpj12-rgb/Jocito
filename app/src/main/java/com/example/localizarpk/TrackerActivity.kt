package com.example.localizarpk

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class TrackerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)

        // 1. Lottie Radar
        val lottieRadar = findViewById<LottieAnimationView>(R.id.lottieRadar)
        lottieRadar.playAnimation()

        // 2. Referencia a Botones
        val btnBloqueo = findViewById<Button>(R.id.btnBloqueo)
        val btnPanico = findViewById<Button>(R.id.btnPanico)
        val btnCamaras = findViewById<Button>(R.id.btnVerCamaras)

        btnCamaras.setOnClickListener {
            startActivity(Intent(this, CamerasActivity::class.java))
        }

        btnPanico.setOnClickListener {
            vibrar(200)
            Toast.makeText(this, "🚨 ALARMA ACTIVADA", Toast.LENGTH_SHORT).show()
        }

        btnBloqueo.setOnClickListener {
            vibrar(600)
            btnBloqueo.text = "MOTOR INMOVILIZADO 🔒"
            btnBloqueo.setBackgroundColor(Color.GRAY)
            btnBloqueo.isEnabled = false
            Toast.makeText(this, "BLOQUEO ENVIADO", Toast.LENGTH_LONG).show()
        }
    }

    private fun vibrar(milisegundos: Long) {
        try {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(milisegundos, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(milisegundos)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}