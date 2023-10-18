package com.example.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.databinding.FragmentABinding

class CFragment: Fragment() {

    var str: String? = null
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            nameFragment.text =getString(R.string.fragmentC)
            btn2.visibility = View.VISIBLE

            btn2.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            tv.visibility = View.VISIBLE
            tv.text = arguments?.getString(STRING_ARG)


            btn1.setOnClickListener {
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, DFragment.newInstance())
                    .commit()
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val STRING_ARG = "STRING_ARG"

        @JvmStatic
        fun newInstance(str: String) = CFragment().apply {
            arguments = Bundle().apply {
                putString(STRING_ARG, str)
            }
        }
    }

}