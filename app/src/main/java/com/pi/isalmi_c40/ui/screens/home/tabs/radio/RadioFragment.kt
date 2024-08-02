package com.pi.isalmi_c40.ui.screens.home.tabs.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pi.isalmi_c40.databinding.FragmentQuranBinding
import com.pi.isalmi_c40.databinding.FragmentRadioBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RadioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RadioFragment : Fragment() {

    lateinit var binding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }
}