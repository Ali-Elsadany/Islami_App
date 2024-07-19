package com.pi.isalmi_c40.ui.screens.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T>: AppCompatActivity() {
    var binding: T? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = initBinding()
    }
    abstract fun initBinding(): T
}