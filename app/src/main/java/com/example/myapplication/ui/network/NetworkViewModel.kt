package com.example.myapplication.ui.network

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.mock.Contact
import com.example.myapplication.data.mock.MockRepository

class NetworkViewModel : ViewModel() {

    val contacts = MockRepository.contacts

    fun toggleSms(contact: Contact) {
        MockRepository.toggleSms(contact)
    }

    fun togglePush(contact: Contact) {
        MockRepository.togglePush(contact)
    }
}