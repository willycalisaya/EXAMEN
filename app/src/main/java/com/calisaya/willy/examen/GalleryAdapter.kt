package com.calisaya.willy.examen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.File
import com.calisaya.willy.examen.databinding.ListItemImgBinding

// Clase Adapter para la visualización de imágenes en un RecyclerView
class GalleryAdapter(private val fileArray: Array<File>) :
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    // Clase ViewHolder que actúa como contenedor para cada elemento en el RecyclerView
    inner class ViewHolder(private val binding: ListItemImgBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Función para enlazar un archivo (imagen) al ImageView correspondiente
        fun bind(file: File) {
            // Carga la imagen utilizando la librería Glide para manejar imágenes de manera eficiente
            Glide.with(binding.root).load(file).into(binding.localImg)
        }
    }

    // Crea una nueva instancia de ViewHolder inflando el diseño de cada ítem en el RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context) // Obtiene el LayoutInflater
        return ViewHolder(ListItemImgBinding.inflate(layoutInflater, parent, false)) // Infla el diseño para el ViewHolder
    }

    // Enlaza los datos al ViewHolder en función de la posición actual en el RecyclerView
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fileArray[position]) // Llama a la función bind para establecer la imagen
    }

    // Devuelve la cantidad de elementos en el RecyclerView (número de imágenes para mostrar)
    override fun getItemCount(): Int {
        return fileArray.size // Devuelve el tamaño de la lista de archivos
    }
}

