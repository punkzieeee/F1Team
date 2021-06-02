package com.punkzieeee.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.punkzieeee.core.R
import com.punkzieeee.core.databinding.ItemsTeamBinding
import com.punkzieeee.core.domain.model.F1Team

class F1Adapter : RecyclerView.Adapter<F1Adapter.ListViewHolder>() {
    private var listData = ArrayList<F1Team>()
    var onItemClick: ((F1Team) -> Unit)? = null

    fun setTeams(newListData: List<F1Team>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_team, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemsTeamBinding.bind(itemView)
        fun bind(data: F1Team) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strTeamBanner)
                    .into(ivItemImage)
                tvTeamName.text = data.strTeam
                tvTeamWebsite.text = data.strWebsite
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}