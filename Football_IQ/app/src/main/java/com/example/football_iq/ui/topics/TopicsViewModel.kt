package com.example.football_iq.ui.topics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopicsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is topics Fragment"
    }
    private val _base = MutableLiveData<String>().apply {
        value = "@string/basic_alignment"
    }
    val text: LiveData<String> = _text
}