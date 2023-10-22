package com.example.motivationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //layoutInflater vem do AppCompatActivity que nossa classe herda
        setContentView(binding.root) //Atribuindo o binding para a view

        supportActionBar?.hide() //Se a supportActionBar existir, será escondida

        handleUserName()

        binding.btnNovaFrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_nova_frase) {

        }
    }

    private fun handleUserName() {
        binding.tvNomeUsuario.text = "Olá, ${SecurityPreferences(this).getString("USER_NAME")}"
    }
}