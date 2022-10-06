package sena.yamboro.devtionary
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DevTionaryBd(context: Context, name: String, factory:
SQLiteDatabase.CursorFactory?, Version: Int):
SQLiteOpenHelper(context,name,factory,Version){

    override fun onCreate(db: SQLiteDatabase) {
        with(db){
            execSQL("create table termino(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, descripcion text, descripcion_ingles text,ejemplo text, categoria text)")
            execSQL("create table categoria(id_categoria INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, descripcion text, descripcion_ingles text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}