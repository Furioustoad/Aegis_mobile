package com.example.aegis.ui.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.aegis.databinding.FragmentNetworkBinding

class NetworkFragment : Fragment() {

    private var _binding: FragmentNetworkBinding? = null
    private val binding get() = _binding!!

    private val networkViewModel: NetworkViewModel by viewModels()
    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNetworkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        contactsAdapter = ContactsAdapter(networkViewModel)
        binding.contactsRecyclerView.adapter = contactsAdapter

        networkViewModel.contacts.observe(viewLifecycleOwner) {
            contactsAdapter.setContacts(it)
        }

        binding.upgradeButton.setOnClickListener {
            Toast.makeText(context, "Upgrade tapped", Toast.LENGTH_SHORT).show()
        }

        binding.addContactButton.setOnClickListener {
            Toast.makeText(context, "Add Contact tapped", Toast.LENGTH_SHORT).show()
        }

        binding.importButton.setOnClickListener {
            Toast.makeText(context, "Import tapped", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}