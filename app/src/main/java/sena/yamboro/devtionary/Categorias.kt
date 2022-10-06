package sena.yamboro.devtionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import sena.yamboro.devtionary.databinding.ActivityCategoriasBinding

class Categorias : AppCompatActivity() {

    lateinit var binding: ActivityCategoriasBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding= ActivityCategoriasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ibmsql.setOnClickListener {
            val intent = Intent(this,ListaPalabras::class.java)
            intent.putExtra("lenguaje","Mysql")
            startActivity(intent)
        }

        binding.ibkotlin.setOnClickListener {
            val intent = Intent(this,ListaPalabras::class.java)
            intent.putExtra("lenguaje","Kotlin")
            startActivity(intent)
        }

        binding.ibhtml.setOnClickListener {
            val intent = Intent(this,ListaPalabras::class.java)
            intent.putExtra("lenguaje","Html5")
            startActivity(intent)
        }

        binding.ibnode.setOnClickListener {
            val intent = Intent(this,ListaPalabras::class.java)
            intent.putExtra("lenguaje","Node.js")
            startActivity(intent)
        }

        binding.ibionic.setOnClickListener {
            val intent = Intent(this,ListaPalabras::class.java)
            intent.putExtra("lenguaje","Ionic")
            startActivity(intent)
        }

        binding.ibjs.setOnClickListener {
            val intent = Intent(this,ListaPalabras::class.java)
            intent.putExtra("lenguaje","JavaScript")
            startActivity(intent)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.info->info()
            R.id.manual->manual()
            R.id.salir->onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun info() {
        startActivity(Intent(this,AcercaDe::class.java))
    }
    private fun manual(){
        startActivity(Intent(this,Manual::class.java))
    }
}