package com.example.artificumlocus.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.artificumlocus.databinding.ListItemChatGroupBinding
import com.example.artificumlocus.models.data.Offer
import com.example.artificumlocus.models.data.User
import com.example.artificumlocus.views.GroupChatFragmentDirections

class GroupChatAdapter(var usserId:Int)  : ListAdapter<Pair<Offer,User>, GroupChatAdapter.ViewHolder>(OfferDiffCallback()){


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(createOnClickListener(item),item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemChatGroupBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    private fun createOnClickListener(item: Pair<Offer,User>): View.OnClickListener
    {
        return View.OnClickListener {
            val direction = GroupChatFragmentDirections.actionGroupChatFragmentToChatFragment(usserId,item.second.id)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(private val binding: ListItemChatGroupBinding): RecyclerView.ViewHolder(binding.root)
    {

        fun bind(listener: View.OnClickListener, item:Pair<Offer,User>)
        {
            binding.apply {
                cardViewMain.setOnClickListener(listener)
                offer = item.first
                user = item.second
                imageView.setImageBitmap(item.first.bitmap)
                executePendingBindings()


            }
        }
    }

    private class OfferDiffCallback: DiffUtil.ItemCallback<Pair<Offer,User>>()
    {
        override fun areContentsTheSame(oldItem: Pair<Offer,User>, newItem: Pair<Offer,User>): Boolean {
            //toDo not good
            return oldItem.first.id == newItem.first.id
        }

        override fun areItemsTheSame(oldItem: Pair<Offer,User>, newItem: Pair<Offer,User>): Boolean {
            //toDo not good
            return oldItem.first.id == newItem.first.id
        }
    }
}