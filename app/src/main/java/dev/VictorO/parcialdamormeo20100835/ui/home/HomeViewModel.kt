package dev.VictorO.parcialdamormeo20100835.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Presupuesto"
    }
    val text: LiveData<String> = _text
}