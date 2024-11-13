package com.example.jordichorro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Tema5_Actividad3.R
import com.example.bancoapiprofe.bd.MiBancoOperacional
import com.example.bancoapiprofe.pojo.Cliente
import com.google.android.material.textfield.TextInputEditText
import com.example.Tema5_Actividad3.MainActivity
import com.example.Tema5_Actividad3.databinding.LoginActivityBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: Button = findViewById(R.id.button_login)
        val dni: TextInputEditText = findViewById(R.id.dni)
        val contrasena: TextInputEditText = findViewById(R.id.password)

        button.setOnClickListener {
            val dniText: String = dni.text.toString()
            val contrasenaText: String = contrasena.text.toString()

            // Crear el objeto Cliente con los datos de inicio de sesión
            var cliente = Cliente()

            cliente.setNif(dniText)
            cliente.setClaveSeguridad(contrasenaText)

            // Obtener instancia de MiBancoOperacional
            val bancoOperacional = MiBancoOperacional.getInstance(this)

            // Llamar a la función login
            val clienteLogueado = bancoOperacional?.login(cliente)

            // Verificar si el inicio de sesión fue exitoso
            if (clienteLogueado != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
