package com.example.sayitahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayitahminet.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivitySonucBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val sonuc: Boolean = intent.getBooleanExtra("sonuc",false)

        if (sonuc == true){
            tasarim.imageViewSonuc.setImageResource(R.drawable.gulen_surat)
            tasarim.sonuc.setText("KAZANDINIZ")
        }else{
            tasarim.imageViewSonuc.setImageResource(R.drawable.uzgun_surat)
            val dogruSonuc:Int = intent.getIntExtra("dogru sonuc",0)
            tasarim.dogruSonuc.setText("Doğru Sonuç: ${dogruSonuc}")
            tasarim.sonuc.setText("KAYBETTİNİZ")
        }

        tasarim.tekrarOyna.setOnClickListener {
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}