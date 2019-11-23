package com.example.artificumlocus.views.adapters

import android.widget.TextView


import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.BaseAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.artificumlocus.R
import com.example.artificumlocus.databinding.MyMessageBinding
import com.example.artificumlocus.models.data.Message


class MessageAdapter : ListAdapter<Message, MessageAdapter.ViewHolder>(OfferDiffCallback()){


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val departure = getItem(position)
        holder.apply {
            bind(departure)
            itemView.tag = departure
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MyMessageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    class ViewHolder(private val binding: MyMessageBinding): RecyclerView.ViewHolder(binding.root)
    {

        fun bind(item:Message)
        {
            binding.apply {
                content = item.content
            }
        }
    }

    private class OfferDiffCallback: DiffUtil.ItemCallback<Message>()
    {
        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.id == newItem.id
        }
    }
}