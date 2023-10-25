package com.example.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragments.R
import com.example.fragments.databinding.FragmentABinding
import com.example.fragments.databinding.FragmentCBinding

class CFragment: Fragment() {

    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    private val args: CFragmentArgs by navArgs()
    private var text:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text = args.stringarg
        binding.tv.text = text

        binding.btnCBack.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.CFragment_to_BFragment2)
        }
        binding.btnCNext.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.CFragment_to_DFragment)
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