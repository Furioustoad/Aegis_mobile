package com.example.myapplication.ui.network

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.mock.Contact
import com.example.myapplication.databinding.ItemContactBinding

class ContactsAdapter(private val viewModel: NetworkViewModel) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    private var contacts = emptyList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.binding.contactName.text = contact.name
        holder.binding.contactPhone.text = contact.phone
        holder.binding.smsSwitch.isChecked = contact.isSmsEnabled
        holder.binding.pushSwitch.isChecked = contact.isPushEnabled

        holder.binding.smsSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.toggleSms(contact)
        }

        holder.binding.pushSwitch.setOnCheckedChangeListener { _, isChecked ->
            viewModel.togglePush(contact)
        }
    }

    override fun getItemCount() = contacts.size

    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)
}