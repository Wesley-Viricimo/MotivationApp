package com.example.motivationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivationapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSalvar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_salvar) {
            handleSave()
        }
    }

    private fun handleSave() {
        val nome = binding.edtNome.text.toString()
        if(nome != "") {
            SecurityPreferences(this).storeString("USER_NAME", nome)

            startActivity(Intent(this, MainActivity::class.java)) //Carrega activity main
            finish() //Irá destruir a activity atual
        } else {
            Toast.makeText(this, R.string.validation_name, Toast.LENGTH_SHORT).show()
        }
    }
}