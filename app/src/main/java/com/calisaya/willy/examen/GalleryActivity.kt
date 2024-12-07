package com.calisaya.willy.examen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.calisaya.willy.examen.databinding.ActivityGalleryBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar el layout
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Acceder al directorio de imágenes
        val directory = File(externalMediaDirs?.firstOrNull()?.absolutePath ?: "")

        // Verificar que el directorio no sea nulo y listar los archivos
        val files = directory.listFiles()?.filter { it.isFile }?.toTypedArray() ?: arrayOf()

        // Configurar el adaptador para el ViewPager2 con los archivos
        val adapter = GalleryAdapter(files.reversedArray())
        binding.viewPager.adapter = adapter
    }
}
