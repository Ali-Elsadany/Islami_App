package com.pi.isalmi_c40.ui.screens.home.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pi.isalmi_c40.databinding.FragmentQuranBinding
import com.pi.isalmi_c40.databinding.FragmentSebhaBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SebhaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SebhaFragment : Fragment() {

    lateinit var binding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }
}