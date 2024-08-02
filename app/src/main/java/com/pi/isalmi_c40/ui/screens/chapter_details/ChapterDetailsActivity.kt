package com.pi.isalmi_c40.ui.screens.chapter_details

import android.os.Bundle
import com.pi.isalmi_c40.databinding.ActivityChapterDetailsBinding
import com.pi.isalmi_c40.ui.screens.base.BaseActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class ChapterDetailsActivity : BaseActivity<ActivityChapterDetailsBinding>() {
    companion object {
        const val FILE_NAME = "file_name"
        const val SURA_NAME = "sura_name"
    }

    lateinit var fileName: String
    lateinit var suraName: String
    var chapterContent = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)
        fileName = intent.getStringExtra(FILE_NAME)!!
        suraName = intent.getStringExtra(SURA_NAME)!!
        readFile()
        binding!!.chapterContentTv.text = chapterContent
    }

    override fun initBinding(): ActivityChapterDetailsBinding =
        ActivityChapterDetailsBinding.inflate(layoutInflater)

    private fun readFile() {
        val reader = BufferedReader(
            InputStreamReader(assets.open("quran/$fileName"), "UTF-8")
        )
        var mLine: String?
        var verseNumber = 1
        mLine = reader.readLine()
        while (mLine != null) {
            chapterContent += mLine + "{${verseNumber}}"
            mLine = reader.readLine()
            verseNumber++
        }
    }
}