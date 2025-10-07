package com.example.aegis.data.mock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

data class Contact(val name: String, val phone: String, var isSmsEnabled: Boolean, var isPushEnabled: Boolean)

object MockRepository {

    private val _isConnected = MutableLiveData(true)
    val isConnected: LiveData<Boolean> = _isConnected

    private val _batteryLevel = MutableLiveData(87)
    val batteryLevel: LiveData<Int> = _batteryLevel

    private val _isGoodSamaritanOn = MutableLiveData(false)
    val isGoodSamaritanOn: LiveData<Boolean> = _isGoodSamaritanOn

    private val _contacts = MutableLiveData(listOf(
        Contact("Sarah Johnson", "(123) 456-7890", true, false),
        Contact("Mike Chen", "(987) 654-3210", false, true)
    ))
    val contacts: LiveData<List<Contact>> = _contacts

    fun toggleGoodSamaritan() {
        _isGoodSamaritanOn.value = !(_isGoodSamaritanOn.value ?: false)
    }

    fun toggleSms(contact: Contact) {
        contact.isSmsEnabled = !contact.isSmsEnabled
        _contacts.value = _contacts.value // Trigger update
    }

    fun togglePush(contact: Contact) {
        contact.isPushEnabled = !contact.isPushEnabled
        _contacts.value = _contacts.value // Trigger update
    }
}