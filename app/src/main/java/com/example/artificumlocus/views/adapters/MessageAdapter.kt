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
import com.example.artificumlocus.databinding.TheirMessageBinding
import com.example.artificumlocus.models.data.Message


class MessageAdapter(var userID:Int) : ListAdapter<Message, RecyclerView.ViewHolder>(OfferDiffCallback()){

    override fun getItemViewType(position: Int): Int {
        if(getItem(position).fromUserId == userID)
            return 1
        return 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if(holder is ViewHolder2)
        {
            holder.apply { bind(item) }
        }
        if(holder is ViewHolder)
        {
            holder.apply { bind(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType== 1 )// moja
        {
            return ViewHolder(MyMessageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }
        return ViewHolder2(TheirMessageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
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
    class ViewHolder2(private val binding: TheirMessageBinding): RecyclerView.ViewHolder(binding.root)
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