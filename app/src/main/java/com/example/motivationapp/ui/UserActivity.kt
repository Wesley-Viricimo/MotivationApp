package com.example.motivationapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivationapp.util.MotivationConstants
import com.example.motivationapp.R
import com.example.motivationapp.util.SecurityPreferences
import com.example.motivationapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSalvar.setOnClickListener(this)

        verifyUserName()
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_salvar) {
            handleSave()
        }
    }

    private fun handleSave() {
        val nome = binding.edtNome.text.toString()
        if(nome != "") {
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, nome)
            initActivityMain()
        } else {
            Toast.makeText(this, R.string.validation_name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun verifyUserName() {
        val nome = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        if(nome != "") {
            initActivityMain()
        }
    }

    private fun initActivityMain() {
        startActivity(Intent(this, MainActivity::class.java)) //Carrega activity main
        finish() //Irá destruir a activity atual
    }
}