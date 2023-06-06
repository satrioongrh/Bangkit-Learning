package com.example.mystoryapp1.auth

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mystoryapp1.MainActivity
import com.example.mystoryapp1.R
import com.example.mystoryapp1.databinding.ActivityLoginBinding
import com.example.mystoryapp1.helper.Constant
import com.example.mystoryapp1.helper.PrefDataUser

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var sharedPref: PrefDataUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = PrefDataUser(this)

        binding.btnLogin.setOnClickListener {
            val inputEmail = binding.edLoginEmail.text.toString()
            val inputPassword = binding.edLoginPassword.text.toString()

            val savedEmail = sharedPref.getDataUser(Constant.PREF_EMAIL)
            val savedPassword = sharedPref.getDataUser(Constant.PREF_PASSWORD)

            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                sharedPref.put(Constant.PREF_IS_LOGIN, true)
                moveIntent()
            } else {
                Toast.makeText(applicationContext, "email/password salah", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        if(sharedPref.isLogin(Constant.PREF_IS_LOGIN)) {
            moveIntent()
        }
    }

    private fun moveIntent() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}