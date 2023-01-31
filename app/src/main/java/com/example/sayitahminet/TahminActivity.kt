package com.example.sayitahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sayitahminet.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityTahminBinding
    private var rastgeleSayi = 0
    private var sayac = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        rastgeleSayi = Random.nextInt(26) // 0 ile 26

        Log.e("Rastgele Sayi", rastgeleSayi.toString())

        tasarim.kalanHak.text = "Kalan Hak: ${sayac}"



        tasarim.tahminEt.setOnClickListener {
            var tahmin = tasarim.girilenSayi.text.toString().toInt()


            if (tahmin > rastgeleSayi) {
                tasarim.yakinlik.text = "Azalt"
            } else if (tahmin < rastgeleSayi) {
                tasarim.yakinlik.text = "Arttır"
            } else {
                var intent = Intent(this, SonucActivity::class.java)
                intent.putExtra("sonuc", true)
                finish()
                startActivity(intent)

                return@setOnClickListener
            }
            sayac--
            tasarim.kalanHak.setText("Kalan Hak: ${sayac}")

            if (sayac == 0) {
                var intent = Intent(this, SonucActivity::class.java)
                intent.putExtra("sonuc", false)
                intent.putExtra("dogru sonuc",rastgeleSayi)
                finish()
                startActivity(intent)
            }
            tasarim.girilenSayi.setText("")

        }
    }
}