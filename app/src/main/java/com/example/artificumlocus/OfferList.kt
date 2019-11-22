package com.example.artificumlocus

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.artificumlocus.databinding.FragmentOffertListBinding
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.models.OfferListViewModel
import com.example.artificumlocus.models.utilites.InjectorUtils
import com.example.artificumlocus.views.adapters.OfferAdapter
import androidx.recyclerview.widget.RecyclerView

import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation




class OfferList : Fragment() {
    private val viewModel: OfferListViewModel by viewModels {
        InjectorUtils.provideOfferListViewModelFactory(requireContext())
    }
    lateinit var binding : FragmentOffertListBinding
    private var checkScrollingUp = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOffertListBinding.inflate(inflater, container, false)
        context ?: return binding.root


        val adapter = OfferAdapter()
        binding.recycleDeparture.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.update(Address())
    }

    private fun subscribeUi(adapter: OfferAdapter) {
        viewModel.offers.observe(viewLifecycleOwner) { offers ->
            /**
             *  Plant may return null, but the [observe] extension function assumes it will not be null.
             *  So there will be a warning（Condition `departures != null` is always `true`） here.
             *  I am not sure if the database return data type should be defined as nullable, Such as `LiveData<List<Plant>?>` .
             */
            if (offers != null) {
                binding.textViewWhenEmpty.visibility = if(offers.isNotEmpty()) View.GONE else View.VISIBLE
                adapter.submitList(offers)
            }
            else{
                binding.textViewWhenEmpty.visibility =View.GONE
            }
        }

    }


}
