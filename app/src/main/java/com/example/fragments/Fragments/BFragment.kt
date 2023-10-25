package com.example.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fragments.R
import com.example.fragments.databinding.FragmentABinding
import com.example.fragments.databinding.FragmentBBinding

class BFragment: Fragment() {

    var str: String = ""
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnBNext.setOnClickListener {view:View ->
            str = binding.edView.text.toString()

            val action = BFragmentDirections.BFragment2ToCFragment(str)

            view.findNavController().navigate(action)
        }

        binding.btnBBack.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.BFragment2_to_AFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val STRING_ARG = "STRING_ARG"

    }


}