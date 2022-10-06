package sena.yamboro.devtionary

import android.content.Context
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.KeyListener
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.Toast
import sena.yamboro.devtionary.databinding.ActivityListaPalabrasBinding
import sena.yamboro.devtionary.databinding.ItemTerminosBinding


class ListaPalabras : AppCompatActivity() {
    lateinit var binding: ActivityListaPalabrasBinding
    lateinit var bd: DevTionaryBd
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityListaPalabrasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        termino()

        val idioma = getString(R.string.Saludo)
        val bundle = intent.extras
        val dato = bundle?.getString("lenguaje")

        binding.tvlangtitle.setText(dato)
        val admin = DevTionaryBd(this, "devTionaryBd", null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery(
            "select nombre,descripcion,descripcion_ingles from categoria where nombre like '${dato}'",
            null
        )
        if(fila.moveToFirst()){
            if (idioma == "Bienvenido"){
                binding.txLangContent.setText(fila.getString(1))
            }else{
                binding.txLangContent.setText(fila.getString(2))
            }
        }



        binding.tiSearch.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_UP &&
                    keyCode == KeyEvent.KEYCODE_ENTER) {
                    if(TextUtils.isEmpty(binding.tiSearch.text.toString())){
                        binding.tiSearch.error = getString(R.string.error)
                        binding.tiSearch.requestFocus()
                        termino()
                    }else{
                        search()
                    }
                    return true
                }
                return false
            }
        })
        binding.btSearch.setOnClickListener {
            if(TextUtils.isEmpty(binding.tiSearch.text.toString())){
                binding.tiSearch.error = getString(R.string.error)
                binding.tiSearch.requestFocus()
                termino()
            }else{
                search()
            }
        }
    }

    fun termino(){
        bd= DevTionaryBd(this, "DevtionaryBd", null, 1)

        val idioma = getString(R.string.Saludo)
        val bundle = intent.extras
        val dato = bundle?.getString("lenguaje")

        val admin = DevTionaryBd(this, "devTionaryBd", null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery(
            "select nombre,descripcion,descripcion_ingles from categoria where nombre like '${dato}'",
            null
        )
        if(fila.moveToFirst()){
            binding.tvlangtitle.setText(fila.getString(0))
            if (idioma == "Bienvenido"){
                binding.txLangContent.setText(fila.getString(1))
            }else{
                binding.txLangContent.setText(fila.getString(2))
            }
        }

        val ursor= bd.rawQuery("select *from termino where categoria='${dato}'", null
        )
        val adapter= CursorAdapterlv(this, ursor)
        binding.verterminos.adapter= adapter
        bd.close()
    }

    fun search(){
        val bundle = intent.extras
        val dato = bundle?.getString("lenguaje")
        val idioma = getString(R.string.Saludo)
            val search = binding.tiSearch.text.toString()
            val admin = DevTionaryBd(this, "devTionaryBd", null, 1)
            val bd = admin.writableDatabase
            if (idioma == "Bienvenido"){
                val consulta = bd.rawQuery(
                    "SELECT * FROM termino WHERE nombre like '%${search}%' AND categoria = '${dato}' OR descripcion like '%${search}%' OR ejemplo like '%${search}%' AND categoria = '${dato}'",
                    null
                )
                val adapter= CursorAdapterlv(this, consulta)
                binding.verterminos.adapter= adapter
                bd.close()
            }else{
                val consulta = bd.rawQuery(
                    "SELECT * FROM termino WHERE nombre like '%${search}%' AND categoria = '${dato}' OR descripcion_ingles like '%${search}%' OR ejemplo like '%${search}%' AND categoria = '${dato}'",
                    null
                )
                val adapter= CursorAdapterlv(this, consulta)
                binding.verterminos.adapter= adapter
                bd.close()
        }
    }

    inner class CursorAdapterlv(context: Context, cursor: Cursor):
        CursorAdapter(context, cursor, FLAG_REGISTER_CONTENT_OBSERVER){
        override fun newView(p0: Context?, p1: Cursor?, p2: ViewGroup?): View {
            val inflater= LayoutInflater.from(p0)
            return inflater.inflate(R.layout.item_terminos, p2, false)
        }

        override fun bindView(p0: View?, p1: Context?, p2: Cursor?) {
            val bindingItems= ItemTerminosBinding.bind(p0!!)
            bindingItems.termino.text= cursor!!.getString(1)
            bindingItems.tvEjemplo.text = cursor!!.getString(4)

            val idioma = getString(R.string.Saludo)

            if (idioma == "Bienvenido"){
                bindingItems.descipcion.text= cursor!!.getString(2)
            }else{
                bindingItems.descipcion.text= cursor!!.getString(3)
            }

        }

    }
}