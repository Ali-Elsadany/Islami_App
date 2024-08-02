package com.pi.isalmi_c40.ui.screens.home.tabs.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.pi.isalmi_c40.databinding.ChapterLayoutBinding
import com.pi.isalmi_c40.ui.model.Chapter

class ChaptersAdapter(val chapters: List<Chapter>, val onItemClick: (Chapter, Int) -> Unit):
    Adapter<ChaptersAdapter.ChaptersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChaptersViewHolder {
       val binding = ChapterLayoutBinding.inflate(LayoutInflater.from(parent.context),
           parent, false)
        return ChaptersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChaptersViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.binding.chapterNameTv.text = chapter.name
        holder.binding.chapterVersesTv.text = chapter.versesNumber.toString()
        holder.binding.root.setOnClickListener {
            onItemClick(chapter, position)
        }
    }
    override fun getItemCount(): Int = chapters.size
    class ChaptersViewHolder(val binding: ChapterLayoutBinding) : ViewHolder(binding.root)
}