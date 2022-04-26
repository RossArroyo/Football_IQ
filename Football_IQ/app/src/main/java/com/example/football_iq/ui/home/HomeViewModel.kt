package com.example.football_iq.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welecome to Football IQ Ross!"
    }
    private val _grade = MutableLiveData<String>().apply {
        value = "Your grade is: "
    }
    val text: LiveData<String> = _text
    val grade: LiveData<String> = _grade
}