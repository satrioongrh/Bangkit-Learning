package com.example.mystoryapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mystoryapp1.auth.LoginActivity
import com.example.mystoryapp1.auth.RegActivity
import com.example.mystoryapp1.databinding.ActivityMainBinding
import com.example.mystoryapp1.helper.Constant
import com.example.mystoryapp1.helper.PrefDataUser
import com.example.mystoryapp1.utils.SessionManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: PrefDataUser
//    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        sessionManager = SessionManager(this)
//        if (!sessionManager.isLoggedIn()) {
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }
        sharedPref = PrefDataUser(this)
        if(!sharedPref.isLogin(Constant.PREF_IS_LOGIN)){
            moveSession()
        }



        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        if(!sharedPref.isLogin(Constant.PREF_IS_LOGIN)){
            moveSession()
        }
    }

    private fun moveSession(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}

//    override fun onStart() {
//        super.onStart()

//        if (!sessionManager.isLoggedIn()) {
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }
//    }
//}