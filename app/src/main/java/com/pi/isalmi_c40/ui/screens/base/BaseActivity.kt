package com.pi.isalmi_c40.ui.screens.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T>: AppCompatActivity() {
    var binding: T? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initBinding()
        Log.e("BaseActivity", "binding = ${binding}")
    }
    abstract fun initBinding(): T
}