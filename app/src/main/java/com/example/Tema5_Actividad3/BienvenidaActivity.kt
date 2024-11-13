package com.example.Tema5_Actividad3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.Tema5_Actividad3.databinding.BienvenidaActivityBinding
import com.example.jordichorro.LoginActivity


class BienvenidaActivity : AppCompatActivity() {
    private lateinit var binding: BienvenidaActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BienvenidaActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: Button = findViewById(R.id.btn_login)
        button.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
