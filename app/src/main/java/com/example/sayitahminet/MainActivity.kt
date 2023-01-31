package com.example.sayitahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayitahminet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.startGame.setOnClickListener{
            startActivity(Intent(this,TahminActivity::class.java))
        }
    }
}