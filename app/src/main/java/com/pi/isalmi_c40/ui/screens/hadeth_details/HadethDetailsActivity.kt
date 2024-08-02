package com.pi.isalmi_c40.ui.screens.hadeth_details

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.pi.isalmi_c40.databinding.ActivityHadethDetailsBinding
import com.pi.isalmi_c40.ui.model.Hadeth
import com.pi.isalmi_c40.ui.screens.base.BaseActivity

class HadethDetailsActivity : BaseActivity<ActivityHadethDetailsBinding>() {
    companion object{
        const val HADETH_KEY = "hadeth";
    }
    lateinit var hadeth: Hadeth

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)
        hadeth = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(HADETH_KEY, Hadeth::class.java)!!
        } else {
            intent.getSerializableExtra(HADETH_KEY) as Hadeth
        }
        binding!!.hadethContentTv.text = hadeth.content

    }

    override fun initBinding(): ActivityHadethDetailsBinding =
        ActivityHadethDetailsBinding.inflate(layoutInflater)
}