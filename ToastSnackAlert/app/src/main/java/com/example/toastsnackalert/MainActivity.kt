package com.example.toastsnackalert

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ToastMesajButton.setOnClickListener {
            Toast.makeText(applicationContext,"Buyrun size toast mesaj", Toast.LENGTH_LONG).show()
        }

        SnackBarButton.setOnClickListener {
            Snackbar.make(SnackBarButton,"Silmek istiyor musunuz?",Snackbar.LENGTH_LONG)
                            .setAction("Evet") {view ->
                                Snackbar.make(view,"Silindi",Snackbar.LENGTH_LONG).show()
                            }
                .show()

        }

        AlertViewButton.setOnClickListener {
            val ad = androidx.appcompat.app.AlertDialog.Builder(this@MainActivity)
            ad.setTitle("Başlığımız")
            ad.setMessage("Mesajımız :)))))")
            ad.setIcon(R.drawable.resim)

            // Positive dememizin sebebi olumlu yanıt alacağımız için
            // d ve i nesneleri oluşturulmazsa hata veriyor.
            ad.setPositiveButton("Tamam"){d,i->
                Snackbar.make(AlertViewButton,"Tamam seçildi",Snackbar.LENGTH_LONG).show()
            }

            ad.setNegativeButton("İptal"){d,i->
                Snackbar.make(AlertViewButton,"İptal seçildi",Snackbar.LENGTH_LONG).show()
            }
            ad.create().show()  // Bu kısımda create sonra show denir, diğerlerinden farklı olarak.
        }

    }
}