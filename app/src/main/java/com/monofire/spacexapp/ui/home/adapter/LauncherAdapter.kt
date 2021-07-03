package com.monofire.spacexapp.ui.home.adapter

import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.monofire.spacexapp.R
import com.monofire.spacexapp.data.model.LauncherResponse
import com.monofire.spacexapp.ui.home.viewholder.LauncherViewHolder

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 17:39          │
//└─────────────────────────────┘
class LauncherAdapter(private val clickListener: (LauncherResponse) -> Unit) :
    RecyclerView.Adapter<LauncherViewHolder>() {
    private val launchers = mutableListOf<LauncherResponse>()

    fun updateList(newProductList: List<LauncherResponse>) {
        launchers.apply {
            clear()
            addAll(newProductList)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LauncherViewHolder {
        return LauncherViewHolder.createHolder(parent)
    }

    override fun onBindViewHolder(holder: LauncherViewHolder, position: Int) {
        val launcher = launchers[position]
        holder.itemView.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.launcher_item_animation)
        holder.bind(launcher, clickListener)
    }

    override fun getItemCount(): Int = launchers.size
}