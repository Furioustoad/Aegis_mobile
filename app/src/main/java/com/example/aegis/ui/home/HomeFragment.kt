package com.example.aegis.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.aegis.R
import com.example.aegis.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.isConnected.observe(viewLifecycleOwner) {
            binding.deviceStatus.text = if (it) "Connected" else "Disconnected"
        }

        homeViewModel.batteryLevel.observe(viewLifecycleOwner) {
            binding.batteryPercentage.text = "$it%"
        }

        homeViewModel.isGoodSamaritanOn.observe(viewLifecycleOwner) {
            binding.goodSamaritanSwitch.isChecked = it
        }

        binding.sosButton.setOnClickListener {
            Toast.makeText(context, "SOS Alert tapped", Toast.LENGTH_SHORT).show()
        }

        binding.sirenButton.setOnClickListener {
            Toast.makeText(context, "Deterrent Siren tapped", Toast.LENGTH_SHORT).show()
        }

        binding.fakeCallButton.setOnClickListener {
            Toast.makeText(context, "Fake Call tapped", Toast.LENGTH_SHORT).show()
        }

        binding.mapPreviewCard.setOnClickListener {
            findNavController().navigate(R.id.navigation_map)
        }

        binding.goodSamaritanSwitch.setOnCheckedChangeListener { _, isChecked ->
            homeViewModel.toggleGoodSamaritan()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}