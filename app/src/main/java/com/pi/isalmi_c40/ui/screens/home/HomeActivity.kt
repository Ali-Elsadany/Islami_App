package com.pi.isalmi_c40.ui.screens.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pi.isalmi_c40.R
import com.pi.isalmi_c40.databinding.ActivityHomeBinding
import com.pi.isalmi_c40.ui.screens.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.main)

    }

    override fun initBinding(): ActivityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
}