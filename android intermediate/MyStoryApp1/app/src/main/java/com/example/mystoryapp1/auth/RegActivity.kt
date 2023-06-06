package com.example.mystoryapp1.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mystoryapp1.MainActivity
import com.example.mystoryapp1.R
import com.example.mystoryapp1.databinding.ActivityRegBinding
import com.example.mystoryapp1.helper.Constant
import com.example.mystoryapp1.helper.PrefDataUser

class RegActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegBinding
    lateinit var sharedPref: PrefDataUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = PrefDataUser(this)

        binding.buttonRegister.setOnClickListener {
            if (binding.edRegisterName.text!!.isNotEmpty() && binding.edRegisterEmail.text!!.isNotEmpty() && binding.edRegisterPassword.text!!.isNotEmpty()) {
                saveSession(
                    binding.edRegisterName.text.toString(),
                    binding.edRegisterEmail.text.toString(),
                    binding.edRegisterPassword.text.toString()
                )
                showMessage()
                moveLogin()
            }
        }
    }

//    override fun onStart() {
//        super.onStart()
//        if(sharedPref.isLogin(Constant.PREF_IS_LOGIN)){
//            moveLogin()
//        }
//    }

    private fun moveLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun saveSession(name: String, email: String, password: String) {
        sharedPref.putDataUser(Constant.PREF_NAME, name)
        sharedPref.putDataUser(Constant.PREF_EMAIL, email)
        sharedPref.putDataUser(Constant.PREF_PASSWORD, password)
//        sharedPref.put(Constant.PREF_IS_LOGIN, true)
    }

    private fun showMessage() {
        Toast.makeText(applicationContext, "Berhasil Register", Toast.LENGTH_SHORT).show()
    }
}