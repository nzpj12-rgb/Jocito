package com.example.localizarpk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- FILA 1 ---
        // 1. Radar
        findViewById<MaterialCardView>(R.id.cardTracker)?.setOnClickListener {
            startActivity(Intent(this, TrackerActivity::class.java))
        }
        // 2. Mapa GPS
        findViewById<MaterialCardView>(R.id.cardLocation)?.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }

        // --- FILA 2 ---
        // 3. Cámaras
        findViewById<MaterialCardView>(R.id.cardCameras)?.setOnClickListener {
            startActivity(Intent(this, CamerasActivity::class.java))
        }
        // 4. Ajustes
        findViewById<MaterialCardView>(R.id.cardSettings)?.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        // --- FILA 3 (Los que faltaban) ---
        // 5. Historial y Diagnóstico (Logs)
        findViewById<MaterialCardView>(R.id.cardLogs)?.setOnClickListener {
            startActivity(Intent(this, LogsActivity::class.java))
        }
        // 6. Sensores (Dashboard)
        findViewById<MaterialCardView>(R.id.cardDashboard)?.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
    }
}