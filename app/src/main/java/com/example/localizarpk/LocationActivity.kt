package com.example.localizarpk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class LocationActivity : AppCompatActivity() {
    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configuración para que el mapa cargue las calles
        Configuration.getInstance().userAgentValue = packageName
        setContentView(R.layout.activity_location)

        map = findViewById(R.id.map)
        map.setMultiTouchControls(true)

        val map = findViewById<org.osmdroid.views.MapView>(R.id.map)
        map.setMultiTouchControls(true)
        val startPoint = org.osmdroid.util.GeoPoint(-37.7214, -72.2411)
        map.controller.setZoom(15.0)
        map.controller.setCenter(startPoint)

    }
}