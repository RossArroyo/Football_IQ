package com.example.football_iq.ui.testing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is testing Fragment"
    }
    val text: LiveData<String> = _text
}