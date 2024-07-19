package com.pi.isalmi_c40.ui.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pi.isalmi_c40.R
import com.pi.isalmi_c40.databinding.ActivitySplashBinding
import com.pi.isalmi_c40.ui.screens.base.BaseActivity
import com.pi.isalmi_c40.ui.screens.home.HomeActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHome()
        }, 2000)
    }

    override fun initBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}