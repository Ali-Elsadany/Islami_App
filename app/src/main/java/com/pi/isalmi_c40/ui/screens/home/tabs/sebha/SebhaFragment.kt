package com.pi.isalmi_c40.ui.screens.home.tabs.sebha

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import com.pi.isalmi_c40.R
import com.pi.isalmi_c40.databinding.FragmentQuranBinding
import com.pi.isalmi_c40.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    var counter = 0
    var currentIndex = 0
    lateinit var azkarList : MutableList<String>
    lateinit var binding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkar_list).toMutableList()
        binding.tasbeehNames.text = azkarList[0]
        onSebhaClicked()
    }

    private fun onSebhaClicked() {
        binding.sebhaBody.setOnClickListener {

            val animator = ObjectAnimator.ofFloat(binding.sebhaBody, "rotation", binding.sebhaBody.rotation, binding.sebhaBody.rotation + 10f)
            animator.duration = 500
            animator.interpolator = LinearInterpolator()
            animator.start()

            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0
                binding.tasbeehNames.text = azkarList[currentIndex]
            }
            binding.tasbeehNumber.text = counter.toString()
        }
    }
    }
