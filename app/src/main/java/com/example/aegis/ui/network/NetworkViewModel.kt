package com.example.aegis.ui.network

import androidx.lifecycle.ViewModel
import com.example.aegis.data.mock.Contact
import com.example.aegis.data.mock.MockRepository

class NetworkViewModel : ViewModel() {

    val contacts = MockRepository.contacts

    fun toggleSms(contact: Contact) {
        MockRepository.toggleSms(contact)
    }

    fun togglePush(contact: Contact) {
        MockRepository.togglePush(contact)
    }
}