package com.example.localizarpk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tvVoltaje = findViewById<TextView>(R.id.tvVoltaje)
        val tvTemp = findViewById<TextView>(R.id.tvTemp)

        // Simulamos que leemos los datos del ESP32
        tvVoltaje.text = "12.6V - Batería OK"
        tvTemp.text = "24°C - Interior"
    }
}