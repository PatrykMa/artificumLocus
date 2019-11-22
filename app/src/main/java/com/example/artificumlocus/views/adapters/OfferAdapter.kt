package com.example.artificumlocus.views.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.artificumlocus.databinding.ListItemOfferBinding
import com.example.artificumlocus.models.data.Offer

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
            Log.d("toDO","implement on click offer")
            //val direction = DepartureFragmentDirections.actionDepartureFragmentToDepartureOptionsDialog(departure.id!!,departure.plate!!)
            //it.findNavController().navigate(direction)
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