package com.example.localizarpk

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class LogsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        val tvConsole = findViewById<TextView>(R.id.tvConsoleLogs)

        // Función para obtener la hora actual (muy útil en logs)
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val currentTime = sdf.format(Date())
        val scrollView = tvConsole.parent as android.widget.ScrollView
        scrollView.post { scrollView.fullScroll(android.widget.ScrollView.FOCUS_DOWN) }

        // Recuperamos el historial o agregamos eventos nuevos
        val nuevoEvento = "[$currentTime] Sistema verificado en Mulchén\n"
        val logAnterior = tvConsole.text.toString()

        // Unimos lo que ya tenías con lo nuevo
        tvConsole.text = "$nuevoEvento$logAnterior"
    }
}