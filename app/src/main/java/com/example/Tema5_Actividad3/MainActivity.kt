package com.example.Tema5_Actividad3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Tema5_Actividad3.databinding.ActivityMainBinding
import com.example.bancoapiprofe.pojo.Cliente

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuario = Cliente().getNombre()

        if (usuario != null) {
            binding.usuario.text = usuario.get(0).toString()
        }
    }
}
