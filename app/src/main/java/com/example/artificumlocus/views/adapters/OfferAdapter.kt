package com.example.artificumlocus.views.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.artificumlocus.OfferListDirections
import com.example.artificumlocus.R
import com.example.artificumlocus.databinding.ListItemOfferBinding
import com.example.artificumlocus.models.data.Offer
import org.jetbrains.anko.bundleOf

class OfferAdapter : ListAdapter<Offer, OfferAdapter.ViewHolder>(OfferDiffCallback()){


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val departure = getItem(position)
        holder.apply {
            bind(createOnClickListener(departure),departure)
            itemView.tag = departure
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemOfferBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    private fun createOnClickListener(offer: Offer): View.OnClickListener
    {
        return View.OnClickListener {
            var bundle = bundleOf("offertId" to offer.id!!)
            //val direction = OfferListDirections.actionOffertListToDetailedOfferFragment(offer.id!!,bundle)
            it.findNavController().navigate(R.id.action_global_detailedOfferFragment,bundle)
        }
    }

    class ViewHolder(private val binding: ListItemOfferBinding): RecyclerView.ViewHolder(binding.root)
    {

        fun bind(listener: View.OnClickListener, item:Offer)
        {
            binding.apply {
                cardViewMain.setOnClickListener(listener)
                offer = item
                imageView.setImageBitmap(item.bitmap)
                executePendingBindings()


            }
        }
    }

    private class OfferDiffCallback: DiffUtil.ItemCallback<Offer>()
    {
        override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem.id == newItem.id
        }
    }
}