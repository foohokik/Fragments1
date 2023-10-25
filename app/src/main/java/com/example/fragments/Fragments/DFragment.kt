package com.example.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.example.fragments.R
import com.example.fragments.databinding.FragmentABinding
import com.example.fragments.databinding.FragmentDBinding

class DFragment: Fragment() {

    private var _binding: FragmentDBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnD.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.DFragment_to_AFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}