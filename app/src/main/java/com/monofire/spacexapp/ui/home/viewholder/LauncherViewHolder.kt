package com.monofire.spacexapp.ui.home.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monofire.spacexapp.data.model.LauncherResponse
import com.monofire.spacexapp.databinding.ListItemLauncherBinding

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 17:43          │
//└─────────────────────────────┘
class LauncherViewHolder(private val binding: ListItemLauncherBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun createHolder(parent: ViewGroup): LauncherViewHolder {
            val binding =
                ListItemLauncherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LauncherViewHolder(binding)
        }
    }

    fun bind(launcher: LauncherResponse, clickListener: (LauncherResponse) -> Unit) {
        binding.launcherItem = launcher
        binding.root.setOnClickListener {
            clickListener.invoke(launcher)
        }
    }
}