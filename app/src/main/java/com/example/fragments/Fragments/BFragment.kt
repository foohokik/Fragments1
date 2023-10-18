package com.example.fragments.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.R
import com.example.fragments.databinding.FragmentABinding

class BFragment: Fragment() {

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

            nameFragment.text =getString(R.string.fragmentB)
            btn2.visibility = View.VISIBLE

            btn2.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            ed.visibility = View.VISIBLE

            btn1.setOnClickListener{
               str = ed.text.toString()
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, CFragment.newInstance(str!!))
                    .commit()
            }



        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = BFragment()
    }
}