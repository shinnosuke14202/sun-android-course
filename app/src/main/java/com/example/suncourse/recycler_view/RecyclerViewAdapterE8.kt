package com.example.suncourse.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.suncourse.databinding.ItemRvE8Binding

class RecyclerViewAdapterE8(private val listItem: MutableList<String>) :
    RecyclerView.Adapter<E8ViewHolder>() {

    lateinit var onItemClick: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): E8ViewHolder {
        val binding = ItemRvE8Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return E8ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: E8ViewHolder, position: Int) {

        holder.bind(listItem[position])

        holder.itemView.setOnClickListener {
            onItemClick.invoke(position)
            notifyItemChanged(position)
        }

    }

    fun addItem(text: String) {
        this.listItem.add(text)
        notifyItemInserted(listItem.size + 1)
    }

}

class E8ViewHolder(private val binding: ItemRvE8Binding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        binding.apply {
            tvE8.text = text
        }
    }
}