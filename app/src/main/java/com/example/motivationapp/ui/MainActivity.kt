package com.example.motivationapp.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivationapp.util.MotivationConstants
import com.example.motivationapp.R
import com.example.motivationapp.util.SecurityPreferences
import com.example.motivationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //layoutInflater vem do AppCompatActivity que nossa classe herda
        setContentView(binding.root) //Atribuindo o binding para a view

        supportActionBar?.hide() //Se a supportActionBar existir, será escondida

        handleUserName()
        handleFilter(R.id.iv_all)

        binding.btnNovaFrase.setOnClickListener(this)
        binding.ivAll.setOnClickListener(this)
        binding.ivHappy.setOnClickListener(this)
        binding.ivSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.btn_nova_frase) {

        } else if(view.id in listOf(R.id.iv_all, R.id.iv_happy, R.id.iv_sunny)) { //Se o componente selecionado estiver entre os elementos da lista
            handleFilter(view.id)
        }
    }

    private fun handleFilter(id: Int) {
        binding.ivAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple)) //Setando cor no componente selecionado
        binding.ivSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple)) //Setando cor no componente selecionado
        binding.ivHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple)) //Setando cor no componente selecionado
        binding.viewAll.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_purple))
        binding.viewSunny.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_purple))
        binding.viewHappy.setBackgroundColor(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.iv_all -> {
                binding.ivAll.setColorFilter(ContextCompat.getColor(this, R.color.white)) //Setando cor no componente selecionado
                binding.viewAll.setBackgroundColor(getColor(R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.iv_sunny -> {
                binding.ivSunny.setColorFilter(ContextCompat.getColor(this, R.color.white)) //Setando cor no componente selecionado
                binding.viewSunny.setBackgroundColor(getColor(R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
            R.id.iv_happy -> {
                binding.ivHappy.setColorFilter(ContextCompat.getColor(this, R.color.white)) //Setando cor no componente selecionado
                binding.viewHappy.setBackgroundColor(getColor(R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
        }
    }

    private fun handleUserName() {
        binding.tvNomeUsuario.text = "Olá, ${SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)}"
    }

}