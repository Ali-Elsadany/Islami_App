package com.pi.isalmi_c40.ui.screens.home.tabs.ahadeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pi.isalmi_c40.databinding.FragmentAhadethBinding
import com.pi.isalmi_c40.databinding.FragmentQuranBinding
import com.pi.isalmi_c40.ui.model.Hadeth
import com.pi.isalmi_c40.ui.screens.chapter_details.ChapterDetailsActivity
import com.pi.isalmi_c40.ui.screens.hadeth_details.HadethDetailsActivity
import com.pi.isalmi_c40.ui.screens.home.tabs.quran.ChaptersAdapter
import com.pi.isalmi_c40.ui.utils.Constants
import java.io.BufferedReader
import java.io.InputStreamReader

class AhadethFragment : Fragment() {

    lateinit var binding: FragmentAhadethBinding
    lateinit var ahadethAdapter: AhadethAdapter
    var ahadeth: MutableList<Hadeth> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
        initAhadethRecyclerView()
    }

    private fun readHadethFile() {
        val reader = BufferedReader(
            InputStreamReader(requireActivity().assets.open("ahadeth/ahadeth.txt"), "UTF-8")
        )
        var mLine: String?
        mLine = reader.readLine()
        val hadeth = mutableListOf<String>()
        while (mLine != null) {
            if(mLine.trim() != "#"){
                hadeth.add(mLine)
            } else{
                val name =hadeth[0];
                hadeth.removeAt(0)
                val content = hadeth.joinToString(" ")
                ahadeth.add(Hadeth(name = name, content = content))
                hadeth.clear()
            }
            mLine = reader.readLine()
        }


    }

    private fun initAhadethRecyclerView() {
        ahadethAdapter = AhadethAdapter(ahadeth) { hadeth, index ->
            val intent = Intent(requireActivity(), HadethDetailsActivity::class.java)
            intent.putExtra(HadethDetailsActivity.HADETH_KEY, hadeth)
            startActivity(intent)
        }
        binding.chaptersRecyclerView.adapter = ahadethAdapter

    }
}