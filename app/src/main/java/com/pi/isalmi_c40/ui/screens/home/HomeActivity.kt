package com.pi.isalmi_c40.ui.screens.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.pi.isalmi_c40.R
import com.pi.isalmi_c40.databinding.ActivityHomeBinding
import com.pi.isalmi_c40.ui.screens.base.BaseActivity
import com.pi.isalmi_c40.ui.screens.home.tabs.ahadeth.AhadethFragment
import com.pi.isalmi_c40.ui.screens.home.tabs.quran.QuranFragment
import com.pi.isalmi_c40.ui.screens.home.tabs.radio.RadioFragment
import com.pi.isalmi_c40.ui.screens.home.tabs.sebha.SebhaFragment

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.main)
        showFragment(QuranFragment())
        initListeners()
    }

    private fun initListeners() {
        binding!!.bottomNavView.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.quran_item -> {
                    showFragment(QuranFragment())
                }
                R.id.sebha_item -> {
                    showFragment(SebhaFragment())
                }
                R.id.ahadeth_item -> {
                    showFragment(AhadethFragment())
                }
                R.id.radio_item -> {
                    showFragment(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun initBinding(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
}