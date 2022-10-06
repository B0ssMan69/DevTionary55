package sena.yamboro.devtionary

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast

class splashdev : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = getSharedPreferences("app", Context.MODE_PRIVATE)
        val estad = preferences.getString("estado","")
        if (estad == ""){
            insertarCategorias()
        }else{
            starTimer()
        }
    }
    fun starTimer() {
        object: CountDownTimer(1500,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent = Intent(applicationContext, Categorias::class.java).apply { }
                startActivity(intent)
                finish()
            }

        }.start()

    }
    fun insertarCategorias() {
        val preferences = getSharedPreferences("app", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        val admin = DevTionaryBd(this,"devTionaryBd", null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("nombre","Kotlin")
        registro.put("Descripcion","nuevo lenguaje de programación de código abierto como Java, JavaScript, etc. Es un lenguaje de alto nivel fuertemente tipado estáticamente que combina parte funcional y técnica en un mismo lugar. Actualmente, Kotlin apunta a Java y JavaScript.")
        registro.put("descripcion_ingles","New open source programming language like Java, JavaScript, etc. It is a strongly statically typed high-level language that combines functional and technical parts in one place. Kotlin currently targets Java and JavaScript.")
        bd.insert("categoria", null, registro)

        registro.put("nombre","Mysql")
        registro.put("descripcion","Sistema de gestión de bases de datos relacional desarrollado bajo licencia dual: Licencia pública general/Licencia comercial por Oracle Corporation y está considerada como la base de datos de código abierto más popular del mundo, y una de las más populares en general junto a Oracle y Microsoft SQL Server, todo para entornos de desarrollo web.")
        registro.put("descripcion_ingles","Relational database management system developed under a dual license: General Public License/Commercial License by Oracle Corporation and is considered the most popular open source database in the world, and one of the most popular in general along with Oracle and Oracle. Microsoft SQL Server, all for web development environments.")
        bd.insert("categoria", null, registro)

        registro.put("nombre","Html5")
        registro.put("descripcion","Es un estándar para estructurar y presentar contenido en la World Wide Web. HTML5 es una cooperación entre el Consorcio World Wide Web (W3C) y el Grupo de Trabajo de Tecnología de Aplicaciones de Hipertexto Web (WHATWG).")
        registro.put("descripcion_ingles","It is a standard for structuring and presenting content on the World Wide Web. HTML5 is a cooperation between the World Wide Web Consortium (W3C) and the Web Hypertext Applications Technology Working Group (WHATWG).")
        bd.insert("categoria", null, registro)

        registro.put("nombre","Node.js")
        registro.put("descripcion","Es un entorno en tiempo de ejecución multiplataforma, de código abierto, para la capa del servidor (pero no limitándose a ello) basado en el lenguaje de programación JavaScript, asíncrono, con E/S de datos en una arquitectura orientada a eventos y basado en el motor V8 de Google.")
        registro.put("descripcion_ingles","It is an open source, cross-platform runtime environment for the server layer (but not limited to) based on the JavaScript programming language, asynchronous, with data I/O in an event-driven architecture and based on Google's V8 engine.")
        bd.insert("categoria", null, registro)

        registro.put("nombre","Ionic")
        registro.put("descripcion","Es un framework para crear aplicaciones híbridas. A día de hoy estamos en la versión 3, y Ionic está basado en Javscript, o lo que es lo mismo, para hacer una aplicación híbrida con Ionic solo tienes que controlar de HTML, CSS y Javascript.")
        registro.put("descripcion_ingles","It is a framework for creating hybrid applications. Today we are in version 3, and Ionic is based on Javscript, or what is the same, to make a hybrid application with Ionic you only have to control HTML, CSS and Javascript.")
        bd.insert("categoria", null, registro)

        registro.put("nombre","JavaScript")
        registro.put("descripcion","Lenguaje de programación interpretado, dialecto del estándar ECMAScript. Se define como orientado a objetos, basado en prototipos, imperativo, débilmente tipado y dinámico")
        registro.put("descripcion_ingles","Interpreted programming language, dialect of the ECMAScript standard. It is defined as object-oriented, prototype-based, imperative, weakly typed, and dynamic.")
        bd.insert("categoria", null, registro)

        insertarTerminos()

        editor.putString("estado","1")
        editor.apply()
        Toast.makeText(this, getString(R.string.Saludo), Toast.LENGTH_LONG).show();
        startActivity(Intent(this,Categorias::class.java))
        finish()
    }
    fun insertarTerminos(){
        val admin = DevTionaryBd(this,"devTionaryBd", null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()

        //mysql

        registro.put("nombre","DROP")
        registro.put("descripcion","Declaración para eliminar una tabla o base de datos existente.")
        registro.put("descripcion_ingles","used to eliminate a table, a database or all databases")
        registro.put("ejemplo","DROP TABLE table_name;\n" +
                "\tDROP DATABASE database_name;")
        registro.put("categoria","Mysql")
        bd.insert("termino", null, registro)

        registro.put("nombre","USE")
        registro.put("descripcion","USE se utiliza para usar una base de datos.")
        registro.put("descripcion_ingles","Statement for use the database.")
        registro.put("ejemplo","USE db_name;")
        registro.put("categoria","Mysql")
        bd.insert("termino", null, registro)

        registro.put("nombre","INSERT INTO")
        registro.put("descripcion","Sentencia que se utiliza para agrega datos a una tabla.")
        registro.put("descripcion_ingles","Used to insert data in a table")
        registro.put("ejemplo","INSERT INTO name_table (content) values (description)")
        registro.put("categoria","Mysql")
        bd.insert("termino", null, registro)

        registro.put("nombre","ALTER")
        registro.put("descripcion","Modificar elementos en las tablas o entidades.")
        registro.put("descripcion_ingles","Change elements from the table")
        registro.put("ejemplo","alter table name_table change column name_column name_incorporated")
        registro.put("categoria","Mysql")
        bd.insert("termino", null, registro)

        registro.put("nombre","JOIN")
        registro.put("descripcion","Permite combinar registros de una o más tablas en una base de datos.")
        registro.put("descripcion_ingles","Used to connect tables")
        registro.put("ejemplo"," Select * from usuarios\n" +
                "->join tables on pk_id = fk_id;")
        registro.put("categoria","Mysql")
        bd.insert("termino", null, registro)

        registro.put("nombre","PRIMARY KEY")
        registro.put("descripcion","Campo que identifica de forma única a cada fila de una tabla")
        registro.put("descripcion_ingles","It's an identifier used to differentiate the unique values")
        registro.put("ejemplo","identification int not null primary key;")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","UPDATE")
        registro.put("descripcion","Comando utilizado para cambia los datos de uno o más registros en una tabla")
        registro.put("descripcion_ingles","Update table content")
        registro.put("ejemplo","update name_table set name_Column = “add information” where primaryKey;")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","VALUES")
        registro.put("descripcion","Información a guardar en una determinada tabla ")
        registro.put("descripcion_ingles","Part of code to insert data in a table")
        registro.put("ejemplo","Insert into nombreTabla(Content) values (‘description’);")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","CONSTRAINT")
        registro.put("descripcion","Se usa en las instrucciones ALTER TABLE y CREATE TABLE para crear o eliminar restricciones")
        registro.put("descripcion_ingles","Part of code to create a connection between two tables")
        registro.put("ejemplo","ALERT table vender add constraint nameRelación foreign key(id _fk)   references entidad(Pk);")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","FOREIGN KEY")
        registro.put("descripcion","Clave de base de datos que se utiliza para vincular dos tablas de la base de datos")
        registro.put("descripcion_ingles","It's at identifier used to differentiate the unique values that belong from another table")
        registro.put("ejemplo","alter table vender add constraint nameRelación foreign key (id _fk)   references    entidad(Pk);")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","AUTO_INCREMENT")
        registro.put("descripcion","El valor se incrementa automaticamnete con cada registro  creado.")
        registro.put("descripcion_ingles","Used to increment one to one the value of a data")
        registro.put("ejemplo","category_id` int (11) AUTO_INCREMENT,")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","VARCHAR")
        registro.put("descripcion","Es un tipo de dato  que permite almacenar una cadena de caracteres hasta 265.")
        registro.put("descripcion_ingles","Datatype used to hold any type of character")
        registro.put("ejemplo","create table test(col1 varchar(max));")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","SHOW")
        registro.put("descripcion","Proporciona información sobre bases de datos, tablas, columnas o información.")
        registro.put("descripcion_ingles","Used to show the structure of a database or a table.")
        registro.put("ejemplo","SHOW DATABASES;\n" +
                "\tSHOW TABLES;")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","ADD")
        registro.put("descripcion","adiciona columnas a una tabla es importante informar la ubicación de la nueva columna. Para ello se utiliza AFTER.")
        registro.put("descripcion_ingles","used to alter data and add the new data")
        registro.put("ejemplo","alter table nombre_tabla ADD nueva_Columna Tipo_dato Modificar AFTER Nombre_columna;")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","SELECT")
        registro.put("descripcion","Permite realizar consultas en una o varias tablas de una base de datos.  ")
        registro.put("descripcion_ingles","Used to show the data from from any table")
        registro.put("ejemplo","SELECT * FROM usuarios;\n"+
                "SELECT nombre, apellidos FROM usuarios")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","INSERT")
        registro.put("descripcion","Permite insertar datos en la tablas de una base de datos.")
        registro.put("descripcion_ingles","allows to insert data into the tables of a database.")
        registro.put("ejemplo","INSERT INTO nombtabla\n" +
                "VALUES (valor1, valor2, ...)")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","WHERE")
        registro.put("descripcion","Palabra clave que restringe nuestro conjunto de resultados de una consulta")
        registro.put("descripcion_ingles","It's a conditional for select, delete and update a specific data")
        registro.put("ejemplo","UPDATE \"nombre_tabla\" SET \"columna_1\" =[nuevo valor]  WHERE \"condicion\";")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","SET")
        registro.put("descripcion","Indica los campos que se van a actualizar y con qué valores lo vamos a hacer.")
        registro.put("descripcion_ingles","Used to indicate the values to update.")
        registro.put("ejemplo","UPDATE \"nombre_tabla\" SET \"columna_1\" =[nuevo valor]  WHERE \"condicion\";")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","RENAME")
        registro.put("descripcion","Cambia el nombre de una tabla.")
        registro.put("descripcion_ingles","Used to change the name of a table.")
        registro.put("ejemplo","alter table personas rename clientes;")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)

        registro.put("nombre","CREATE")
        registro.put("descripcion","Comando utilizado para crear una base de datos o una tabla.")
        registro.put("descripcion_ingles","Used to create a database or a table.")
        registro.put("ejemplo","CREATE DATABASE mydb;\n" +
                "CREATE TABLE mi tabla ( id INT PRIMARY KEY, nombre VARCHAR(20) );")
        registro.put("categoria","Mysql")
        bd.insert("termino",null,registro)



        //kotlin
        registro.put("nombre","Intent")
        registro.put("descripcion","El Intent representa la intención que tiene una app de realizar una tarea, intent inicia otra actividad")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","Intent(this,mainactivity::class.java)")
        registro.put("categoria","Kotlin")
        bd.insert("termino", null, registro)

        registro.put("nombre","close()")
        registro.put("descripcion","Se utiliza para cerrar la bade de datos")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","val = bd.close()")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","setOnClickListener()")
        registro.put("descripcion","Es un detector de eventos, lo que significa que solo se invocará cuando se produzca un evento, como un clic en un botón")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","boton.setOnClickListener{Intent(this,mainactivity::class.java)}")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","Binding")
        registro.put("descripcion","Es la vinculacion de vistas generando una vinculacion para cada XML presente en el modulo")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo"," private lateinit var binding: ActivityMainBinding\n" +
                "override fun onCreate(savedInstanceState: Bundle?) {\n" +
                "super.onCreate(savedInstanceState)\n" +
                "binding = ActivityMainBinding.inflate(layoutInflater)\n" +
                "setContentView(binding.root)\n" +
                "}")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","fun()")
        registro.put("descripcion","Sire para definir un funcion, entre paréntesis se pueden indicar los parámetros que recibe la función")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","fun onFinish(){finish()}")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","import")
        registro.put("descripcion","El proceso de importación de las dependencias, bibliotecas y proyectos a Android Studio")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","putExtra()")
        registro.put("descripcion","Agrega datos extendidos a la intención.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","class")
        registro.put("descripcion","Es la clase base dentro de una aplicación de Android que contiene todos los demás componentes, como actividades y servicios.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","class Main: ActivityMain(){}")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","onBackPressed")
        registro.put("descripcion","Se utiliza para poder navegar hacia atrás en una aplicación")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","override")
        registro.put("descripcion","Se refiere a la posibilidad de que una subclase cuente con métodos con el mismo nombre que los de una clase superior")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","overraide fun onCreate(savedIntanceState: Bundle?){}")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","if()")
        registro.put("descripcion","Es un condicional que nos permite ejecutar un bloque de código concreto si se cumple cierta condición")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","if(idioma==”es”){\n" +
                "esta en español\n" +
                "}else{it is in english})")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","start")
        registro.put("descripcion","")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","pacKage")
        registro.put("descripcion","Es una forma muy efectiva de organizar nuestro código para ser utilizado en nuestro proyecto o reutilizado por otros")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","inner class")
        registro.put("descripcion","Se utiliza para crear una clase inmersa dentro de otra clase ")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","move Tofrist")
        registro.put("descripcion","Permite probar si la consulta devolvió un conjunto vacío")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","pawQuery")
        registro.put("descripcion","Permite realizar una consulyta SQLite")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","val")
        registro.put("descripcion","Se usa para definir una variable cuyo valor no cambia nunca")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","val idioma= getString(R.id.saludo)")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","var")
        registro.put("descripcion","Se usa para definir una variable cuyo valor puede cambiarse")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","var  nombre = string()")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","imagenButton")
        registro.put("descripcion","Permitirá utilizar una imagen cualquiera como un botón, sobre el cual el usuario puede pulsar para ir, por ejemplo, a otra actividad.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","getString")
        registro.put("descripcion","Se utilizan para octener un texto")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","getInit")
        registro.put("descripcion","Se utiliza para octener un numero")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","getDouble")
        registro.put("descripcion","Se utiliza para octener un decimal")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","StartActivity")
        registro.put("descripcion","Esta funcion se utiliza para iniciar un nueva pantalla en una aplicaion movil, para ello hace uso de la  funcion Intent")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","StartActivity(Intent(this,mainactiviy::class.java))")
        registro.put("categoria","Kotlin")
        bd.insert   ("termino", null, registro)



        //Html5
        registro.put("nombre","<br>")
        registro.put("descripcion","Se usa para definir un salto de línea")
        registro.put("descripcion_ingles","Make a line break")
        registro.put("ejemplo","<br><div class=\"text\">DevTionary (Diccionario para desarrolladores)</div><br>")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<! DOCTYPE html>")
        registro.put("descripcion","Comando utilizado para declarar un archivo como html5 ")
        registro.put("descripcion_ingles","Used to declare an archive like an html5")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<h1>a<h6>")
        registro.put("descripcion","Define encabezados o títulos")
        registro.put("descripcion_ingles","Define headings or title")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<body></body>")
        registro.put("descripcion","Define el cuerpo del documento HTML")
        registro.put("descripcion_ingles","Define the body of the document ")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<head></head>")
        registro.put("descripcion","Define la cabecera del archivo HTML")
        registro.put("descripcion_ingles","Defines the file header")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<title></title>")
        registro.put("descripcion","Muestra el título en la cabecera del archivo HTML")
        registro.put("descripcion_ingles","Show title in file header")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<video>")
        registro.put("descripcion","Permite incluir un video o película.")
        registro.put("descripcion_ingles","Allows you to include a video or movie.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<a></a>")
        registro.put("descripcion","Crea un enlace a otra página html o parte de la misma página.")
        registro.put("descripcion_ingles","Defines a type the hyperlink")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<article>")
        registro.put("descripcion","Permite separar diversos elementos independientes que puedan estar contenidos en uno mismo.")
        registro.put("descripcion_ingles","Allows you to separate various independent elements that may be contained in the same")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<audio>")
        registro.put("descripcion","Define contenido de sonido.")
        registro.put("descripcion_ingles","defines the contento f the sond")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<b></b>")
        registro.put("descripcion","Define un texto en negrilla")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<button></button>")
        registro.put("descripcion","Se utiliza para crear un botón en el archivo de HTML")
        registro.put("descripcion_ingles","Is used to create a button in the HTML file")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<embed></embed>")
        registro.put("descripcion","El elemento embed provee los medios para insertar aplicaciones externas, típicamente aquellas que requieren un plugin, en el documento")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<input>")
        registro.put("descripcion","Se usa para crear controles interactivos para formularios basados en la web con el fin de recibir datos del usuario.")
        registro.put("descripcion_ingles","Is used to create interactive controls for web-based forms to receive user input.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<p>")
        registro.put("descripcion","Distribuye texto en párrafos.")
        registro.put("descripcion_ingles","Is appropriate for distributing the text in paragraphs.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<form> ")
        registro.put("descripcion","Representa una sección de un documento que contiene controles interactivos que permiten a un usuario enviar información a un servidor web.")
        registro.put("descripcion_ingles","Represents a section of a document that contains interactive controls that allow a user to submit information to a web server.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<label>")
        registro.put("descripcion","Representa una etiqueta para un elemento en una interfaz de usuario. ")
        registro.put("descripcion_ingles","Represents a label for an element in a user interface.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<select>")
        registro.put("descripcion","Representa un control que muestra un menú de opciones")
        registro.put("descripcion_ingles","Represents a control that displays a menu of options.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<img>")
        registro.put("descripcion","Etiqueta para mostrar una imagen en un documento html.")
        registro.put("descripcion_ingles","Renders an image in the document.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","<div>")
        registro.put("descripcion","Define las divisiones existentes en el contenido de una página web.")
        registro.put("descripcion_ingles","Defines the existing logical divisions in the content of a web page.")
        registro.put("ejemplo","")
        registro.put("categoria","Html5")
        bd.insert   ("termino", null, registro)

        //Ionic
        registro.put("nombre","ionic start")
        registro.put("descripcion","Comando utilizado para crea una aplicación Ionic que instala dependencias por usted y configura su proyecto.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ionic serve")
        registro.put("descripcion","Activa fácilmente un servidor de desarrollo que se inicia en tu navegador")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-text")
        registro.put("descripcion","El componente de texto es un componente simple que se puede usar para diseñar el color del texto de cualquier elemento. Y escribir texto.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-alert")
        registro.put("descripcion","Una alerta es un cuadro de diálogo que presenta a los usuarios información o recopila información del usuario mediante entradas.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-button")
        registro.put("descripcion","El componente Buttons es un elemento contenedor. Los botones colocados en una barra de herramientas deben colocarse dentro del <ion-buttons>elemento.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-item")
        registro.put("descripcion","Los elementos que pueden contener texto, íconos, avatares, imágenes, entradas y cualquier otro elemento nativo o personalizado. Generalmente se colocan en una lista con otros elementos.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-menu")
        registro.put("descripcion","El componente Menú es un cajón de navegación que se desliza desde el costado de la vista actual para ver los diferentes componentes que tenga en el menú  ")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-avatar")
        registro.put("descripcion","Los avatares son componentes circulares que normalmente envuelven una imagen o icono. Se pueden utilizar para representar a una persona o un objeto.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-checkbox")
        registro.put("descripcion","Las casillas de verificación se pueden usar para que el usuario sepa que necesita tomar una decisión binaria.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-infinite-scroll")
        registro.put("descripcion","El desplazamiento infinito le permite cargar nuevos datos a medida que el usuario se desplaza por su aplicación.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-segment")
        registro.put("descripcion","Los segmentos proporcionan un conjunto de botones exclusivos que se pueden usar como filtro o selector de vista.\n")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ion-refresher")
        registro.put("descripcion","Refresher proporciona la funcionalidad de extracción para actualizar en un componente de contenido.\n")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ng-app")
        registro.put("descripcion","Esta es la marca que indica el elemento raíz de la aplicación. Es una directiva que autoarranca la aplicación web AngularJS.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","*ngIf")
        registro.put("descripcion","Una directiva estructural que incluye condicionalmente una plantilla basada en el valor de una expresión forzada a booleana.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","ng serve ")
        registro.put("descripcion","Construye su aplicación, e inicia con los cambios actualizados en los archivos.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Ionic")
        bd.insert   ("termino", null, registro)

        //JavaScript
        registro.put("nombre","Funcion")
        registro.put("descripcion","Permite agrupar líneas de código en tareas con un nombre, para que, posteriormente,  hacer referencia a ese nombre para realizar todo lo que se agrupe en dicha tarea. Para usar la  funcion hay que hacer 2 cosas:")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","//Declaración de la función \"saludar\"\n" +
                "function saludar() {\n" +
                "  // Contenido de la función\n" +
                "  console.log(\"Hola, soy una función\");\n" +
                "}\n" +
                "// Ejecución de la función\n" +
                "saludar();")
        registro.put("categoria","JavaScript")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","Generadores")
        registro.put("descripcion","Es un objeto que sirve para decirle a`JavaScript`que nuestra función es un generador y se debe indicar con un asterisco de la siguiente forma:")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","\n" +
                "function* generador() { \n" +
                "   yield 1;\n" +
                "   yield 2;\n" +
                "   yield 3;\n" +
                "}\n" +
                "var g = generador();   // \"Generador { }\"    ")
        registro.put("categoria","JavaScript")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","")
        registro.put("descripcion","")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","JavaScript")
        bd.insert   ("termino", null, registro)

        registro.put("nombre","Click")
        registro.put("descripcion","Se activa cuando se presiona el botón del mouse y ejecuta una función que recibe como parámetro, dicha función recibe el evento.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","const button = document.getElementById(\"test\")\n" +
                "button.addEventListener(\"click\",function(event{\n" +
                "  console.log('hola mundo')\n" +
                "}\n")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","")
        registro.put("descripcion","")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Const")
        registro.put("descripcion","Define una constante que no va a cambiar su valor durante el tiempo    ")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","const nombre  = 'Juanito'")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Constructor")
        registro.put("descripcion","El método constructor es un método especial para crear e inicializar un objeto creado a partir de una clase.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","Sintaxis: constructor([arguments]) {...}")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Document.getElementById")
        registro.put("descripcion","Devuelve el elemento por su id; id que se usa para identificar de forma única el elemento, que se encuentra en el html con el atributo`id`.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","<div id=\"ejemplo\"></div>\n" +
                "let element = document.getElementById('ejemplo');\n")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Document.getElementsByClassName")
        registro.put("descripcion","Devuelve una colección que contiene todos los elementos que contenga la clase del atributo, por ejemplo.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","<div class=\"ejemplo\"></div>\n" +
                "<div class=\"ejemplo\"></div>\n" +
                "var ejemplo= document.getElementsByClassName(\"ejemplo\")\n" +
                "  ejemplo[0].innerHTML = \"Soy la clase ejemplo del primer div!\"\n")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Element.setAttribute")
        registro.put("descripcion","Agrega el valor de un atributo en el elemento especificado. Si el atributo ya existe, el valor se actualiza, en el caso contrario se agrega el atributo con el nombre y el valor especificado.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","element.setAttribute (nombre, value);\n" +
                "name // especifica el nombre del atributo que se va a establecer. string\n" +
                "value // contiene el valor a asignar al atributo. string\n")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Eventos")
        registro.put("descripcion","Permiten la interacción entre las aplicaciones JavaScript y los usuarios. Cuando se toca un botón, cuando se pulsa una tecla determinada, se produce un evento. Sin embargo no todos los eventos los produce el usuario, cuando se carga una pagina también se produce un evento.")
        registro.put("descripcion_ingles","")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Variables")
        registro.put("descripcion","Son espacios de memoria donde almacenamos temporalmente datos, que podemos acceder en algún momento de la ejecución de nuestro código.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","`var Numero;`\n" +
                "`var numero = 5;`\n")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Let")
        registro.put("descripcion","Define el ámbito de la`variable`en donde a sido definida global o ámbito de una function.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","let saludar = \"dice Hola\"\n" +
                "        \tconsole.log(hola);// \"dice Hola tambien\"")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","console.log")
        registro.put("descripcion","Se utiliza para mostrar texto o variables en la consola, función utilizada para los desarrolladores.  ")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","console.log(edad)//19")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","alert")
        registro.put("descripcion","Muestra información o resultados de una operación por pantalla. También es usada para mostrar alertas de advertencia al usuario.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","let nombre = “Gabriel” \n" +
                "\talert(‘usted se llama: ‘+nombre)")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","<SCRIPT>")
        registro.put("descripcion","Atributo que sirve para indicar el lenguaje que estamos utilizando, así como la versión de este.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","< script language=\"javascript\">")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Date")
        registro.put("descripcion","Permite  trabajar de forma fácil y práctica con fechas")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","variable date\n" +
                "const date = new Date();")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","push")
        registro.put("descripcion","Es usado para agregar un elemento al final de un arreglo.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","const arr = ['First item', 'Second item', 'Third item'];\n" +
                "\n" +
                "arr.push('Fourth item');")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","toString")
        registro.put("descripcion","Retorna una cadena representando el código fuente de la función.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","var objeto = new Object();\n" +
                "objeto.toString(); // Devuelve [object Object]")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Number.parseInt")
        registro.put("descripcion","Analiza un argumento de cadena y devuelve un entero de la raíz o base especificada.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","String")
        registro.put("descripcion","Se utiliza para representar datos textuales.\n " +
                "Puedes crear cadenas simples utilizando comillas simples o dobles:")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        registro.put("nombre","Array")
        registro.put("descripcion","Proporciona métodos para efectuar operaciones de recorrido y de mutación.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","JavaScript")
        bd.insert("termino", null, registro)

        //Node.js
        registro.put("nombre","Nodemon")
        registro.put("descripcion","Vigila la ejecución de la aplicación y la reinicia automáticamente para implementar los cambios que se van incluyendo en la aplicación.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","console.log")
        registro.put("descripcion","Función que muestra al desarrollador  la iteración del código para buscar o corregir errores")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","if")
        registro.put("descripcion","La sentencia if, evalúa si se cumple una condición para ejecutar una tarea específica.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","else")
        registro.put("descripcion","La sentencia else ejecuta un código alternativo si en la sentencia if no se cumple la condición, adicionando una tarea diferente.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Const")
        registro.put("descripcion","Se utiliza para declarar una constante es decir, toma un valor que no cambia durante toda la ejecución")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","var")
        registro.put("descripcion","Permite declara una variable, opcionalmente se puede inicializar esta variable con un valor determinado. ")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","let")
        registro.put("descripcion","Permite declarar variables limitando su alcance al bloque, declaración, o expresión donde se está usando, let es una actualización de la función var en ejx.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Express")
        registro.put("descripcion","Permite que se desarrollen funcionalidades tales como el enrutamiento, que se utiliza para almacenar información sobre redes que se encuentran conectadas y permite el trafico de información de forma sencilla")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Body-Parser")
        registro.put("descripcion","Permite a la aplicación recibir datos que se pueden almacenar dentro de una variable.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Morgan")
        registro.put("descripcion","Permite capturar solicitudes HTTP para su posterior registro y seguimiento")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Listen")
        registro.put("descripcion","Se utiliza para asignar el puerto al servidor del API")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","package.Json")
        registro.put("descripcion","Utilizado para almacenar las dependencias empleadas en una aplicación o un Api.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Get")
        registro.put("descripcion","Método permite al cliente enviar información al servidor a través de la url")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Post")
        registro.put("descripcion","(En una aplicación web) recibe parámetros que son enviados desde la web.\n" +
                "(En una API REST) Se utiliza para recibir cierta información o parámetros y realizar una tarea específica.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Try/catch")
        registro.put("descripcion","Función que se utiliza en caso de error inesperado en el código y lo captura para mandar un mensaje de error.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Update")
        registro.put("descripcion","Permite la actualización de un dato")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","router")
        registro.put("descripcion","Usada para crear manejadores de rutas montables y modulares.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Module.exports")
        registro.put("descripcion","Agrupan código que realiza cierta función y se puede importar en otro archivo donde se necesite.")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","Urlencoded")
        registro.put("descripcion","El parámetro de opciones contiene varias propiedades como extender, inflar, limitar, verificar, etc")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)

        registro.put("nombre","require")
        registro.put("descripcion","lee un archivo JavaScript, ejecuta el archivo y luego procede a devolver el objeto de exportación")
        registro.put("descripcion_ingles","")
        registro.put("ejemplo","")
        registro.put("categoria","Node.js")
        bd.insert("termino", null, registro)


    }

}