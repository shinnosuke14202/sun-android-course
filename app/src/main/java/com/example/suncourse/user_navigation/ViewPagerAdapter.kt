package com.example.suncourse.user_navigation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.suncourse.databinding.ItemViewPagerBinding

class ViewPagerAdapter(private val list: List<String>) :
    RecyclerView.Adapter<ViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding = ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(list[position])
    }

}

class ViewPagerViewHolder(private val binding: ItemViewPagerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        binding.apply {
            tvText.text = text
        }
    }
}