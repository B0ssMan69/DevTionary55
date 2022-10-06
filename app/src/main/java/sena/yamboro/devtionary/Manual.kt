package sena.yamboro.devtionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sena.yamboro.devtionary.databinding.ActivityManualBinding


class Manual : AppCompatActivity() {
    private lateinit var binding: ActivityManualBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityManualBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idioma = getString(R.string.Saludo)

        if(idioma == "Bienvenido"){
            binding.webView.loadUrl("file:///android_asset/index.html")
        }else{
            binding.webView.loadUrl("file:///android_asset/indexIngles.html")
        }

    }
}