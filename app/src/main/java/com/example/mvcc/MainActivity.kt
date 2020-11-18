package com.example.mvcc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import java.util.*

// para no usar findViewById
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instanciamos el ViewModel
        // nomenclatura que necesita utilizar jvm 1.8
        // se configure en project structure -> Modules -> Target Compatibillity

        val miModelo by viewModels<MyViewModel>()

        /*val texto = findViewById<TextView>(R.id.textRonda)
        texto.text = miModelo.ronda.value.toString()*/


// observamos cambios en ronda y actualizamos textView
        miModelo.ronda.observe(this, Observer {
                nuevaRonda -> textRonda.text = nuevaRonda.toString()
        })

        sumarRonda.setOnClickListener {
            miModelo.sumarRonda()
        }
        comienzo.setOnClickListener {
            miModelo.ronda.value=0
        }

    }
}