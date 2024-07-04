package com.example.suncourse.content_provider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.suncourse.databinding.ItemContactBinding

class ContactAdapter(private val contactItems : MutableList<ContactItem>) : RecyclerView.Adapter<ContactItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val binding = ItemContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ContactItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactItems.size
    }

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        holder.bind(contactItems[position])
    }
}

class ContactItemViewHolder(private val binding : ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item : ContactItem) {
        binding.apply {
            tvPhoneNumber.text = item.phoneNumber
            tvContactName.text = item.name
            if (item.avatar != null) {
                ivAvatar.setImageURI(item.avatar)
            }
        }
    }
}