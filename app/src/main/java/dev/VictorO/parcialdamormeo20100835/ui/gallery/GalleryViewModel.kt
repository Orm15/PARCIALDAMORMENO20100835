package dev.VictorO.parcialdamormeo20100835.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Seguros"
    }
    val text: LiveData<String> = _text
}