package com.pi.isalmi_c40.ui.screens.home.tabs.ahadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.pi.isalmi_c40.databinding.HadethLayoutBinding
import com.pi.isalmi_c40.ui.model.Chapter
import com.pi.isalmi_c40.ui.model.Hadeth

class AhadethAdapter(val hadeth: List<Hadeth>, val onItemClick: (Hadeth, Int) -> Unit):
    Adapter<AhadethAdapter.HadethViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
       val binding = HadethLayoutBinding.inflate(LayoutInflater.from(parent.context),
           parent, false)
        return HadethViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        val hadeth = hadeth[position]
        holder.binding.hadethNameTv.text = hadeth.name
        holder.binding.root.setOnClickListener {
            onItemClick(hadeth, position)
        }
    }
    override fun getItemCount(): Int = hadeth.size
    class HadethViewHolder(val binding: HadethLayoutBinding) : ViewHolder(binding.root)
}