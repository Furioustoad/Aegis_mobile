package com.example.myapplication.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.zoomInButton.setOnClickListener {
            Toast.makeText(context, "Zoom in tapped", Toast.LENGTH_SHORT).show()
        }

        binding.zoomOutButton.setOnClickListener {
            Toast.makeText(context, "Zoom out tapped", Toast.LENGTH_SHORT).show()
        }

        binding.checkInButton.setOnClickListener {
            Toast.makeText(context, "Check In tapped", Toast.LENGTH_SHORT).show()
        }

        binding.addLocationButton.setOnClickListener {
            Toast.makeText(context, "Add Location tapped", Toast.LENGTH_SHORT).show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}