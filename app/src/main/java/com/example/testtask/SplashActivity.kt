package com.example.testtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        GlobalScope.launch(Dispatchers.Main){
            runScreenFirst()
        }
    }

    private suspend fun  runScreenFirst(){
        delay (3000)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}