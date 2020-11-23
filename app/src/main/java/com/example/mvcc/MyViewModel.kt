package com.example.mvcc

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel() : ViewModel(){
    // ronda actual del juego
    // definimos la ronda actual
    val ronda = MutableLiveData<Int>()

    // para las corutinas
    val msjBoton = MutableLiveData<String>()

    //para habilitar y deshabuilitar el boton ronda
    val botonEnable = MutableLiveData<Boolean>()

    // inicializamos variables cuando instanciamos
    init {
        ronda.value = 1
        msjBoton.value = "Start"
        botonEnable.value = true
    }

    fun sumarRonda() {
        // añadimos uno a la ronda
        // tenemos que chequear si es null
        // lo podemos hacer con un 'if'
        ronda.value = ronda.value?.plus(1)
    }

    fun salidaLog() {
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("MisCorutinas","Lanzo corutina")
            msjBoton.value = "STOP"
            botonEnable.value = false
            delay(5000)
            msjBoton.value = "START"
            botonEnable.value = true
            Log.d("MisCorutinas","acabo la corutina")
        }
    }
}