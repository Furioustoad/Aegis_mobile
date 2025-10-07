package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.mock.MockRepository

class HomeViewModel : ViewModel() {

    val isConnected = MockRepository.isConnected
    val batteryLevel = MockRepository.batteryLevel
    val isGoodSamaritanOn = MockRepository.isGoodSamaritanOn

    fun toggleGoodSamaritan() {
        MockRepository.toggleGoodSamaritan()
    }
}