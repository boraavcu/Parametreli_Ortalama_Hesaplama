package com.example.Parametreli_Ortalama_Hesaplama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ortalama = 0.0
        var vizeAgirlik = 0.2
        var odevAgirlik = 0.2
        var finalAgirlik = 0.6

        // EditTextler İdleri İle Bulunması Ve Eşitlenmesi
        val vizeAgirlikInput = findViewById<EditText>(R.id.edittext_vize_agirlik)
        val odevAgirlikInput = findViewById<EditText>(R.id.edittext_odev_agirlik)
        val finalAgirlikInput = findViewById<EditText>(R.id.edittext_final_agirlik)
        val vize = findViewById<EditText>(R.id.edittext_vize)
        val odev = findViewById<EditText>(R.id.edittext_odev)
        val final = findViewById<EditText>(R.id.edittext_final)
        // Sonuç İçin Bir TextView Tanımladım.
        val ortalamaTextView = findViewById<TextView>(R.id.textview_ortalama)
        findViewById<Button>(R.id.button).setOnClickListener {
            // EditTextlere Girilen Değerlerin En Doğru Sonuç Ulaşması İçin Double Türüne dönüştürdüm.
            val vizeNotu = vize.text.toString().toDoubleOrNull() ?: 0.0
            val odevNotu = odev.text.toString().toDoubleOrNull() ?: 0.0
            val finalNotu = final.text.toString().toDoubleOrNull() ?: 0.0
            if (vizeNotu > 100.0 || odevNotu > 100.0 || finalNotu > 100.0) {
                Toast.makeText(this, "Notlar 100'den Büyük Olamaz !", Toast.LENGTH_SHORT).show()
            } else {
                vizeAgirlik = vizeAgirlikInput.text.toString().toDoubleOrNull() ?: 0.0
                odevAgirlik = odevAgirlikInput.text.toString().toDoubleOrNull() ?: 0.0
                finalAgirlik = finalAgirlikInput.text.toString().toDoubleOrNull() ?: 0.0
                if (vizeAgirlik + odevAgirlik + finalAgirlik != 100.0) {
                    Toast.makeText(this, "Ağırlık Değerleri 100'e Eşit Olmalıdır  100'den Küçük Veya Büyük Olamaz !", Toast.LENGTH_SHORT).show()}
                else{
                    // Ortalama hesaplama
                    ortalama = vizeNotu * vizeAgirlik + odevNotu * odevAgirlik + finalNotu * finalAgirlik
                    fun HarfNotu(ortalama: Double): String { // Değerleri Kolaylıkla Çekmek İçin "HarfNotu" Adında Fonksiyon Oluşturdum.
                        return if (ortalama/100.0 < 50) {
                            "FF"
                        } else if (ortalama/100.0 < 60) {
                            "FD"
                        } else if (ortalama/100.0 < 65) {
                            "DD"
                        } else if (ortalama/100.0 < 70) {
                            "DC"
                        } else if (ortalama/100.0 < 75) {
                            "CC"
                        } else if (ortalama/100.0 < 80) {
                            "CB"
                        } else if (ortalama/100.0 < 85) {
                            "BB"
                        } else if (ortalama/100.0 < 90) {
                            "BA"
                        } else {
                            "AA"
                        }
                    }
                    val HarfNotu = HarfNotu(ortalama) // "HarfNotu" Fonksiyonun Döndürdüğü Harf Notunu "HarfNotu" Değişkeninde Sakladım.
                    // Sonuçları TextViewa Yazdırdım.
                    ortalamaTextView.text = "Ortalama: ${(ortalama/100.0)}"+" Harf Notu: $HarfNotu"
                }
            }
    }
}
}