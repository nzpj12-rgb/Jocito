package com.example.localizarpk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color

class AlertasAdapter(private val lista: List<String>) :
    RecyclerView.Adapter<AlertasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagen: ImageView = view.findViewById(android.R.id.icon)
        val texto: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Usamos un layout estándar de Android que tiene icono y texto
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.activity_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.texto.text = "${lista[position]}\nDetectado 14:02"
        holder.texto.setTextColor(Color.WHITE)
        holder.imagen.setImageResource(android.R.drawable.ic_menu_camera)
        holder.imagen.setColorFilter(Color.parseColor("#00E5FF"))

        // Efecto visual de fondo para cada item
        holder.itemView.setBackgroundColor(Color.parseColor("#1A1A1A"))
        holder.itemView.layoutParams = (holder.itemView.layoutParams as ViewGroup.MarginLayoutParams).apply {
            setMargins(8, 8, 8, 8)
        }
    }

    override fun getItemCount() = lista.size
}