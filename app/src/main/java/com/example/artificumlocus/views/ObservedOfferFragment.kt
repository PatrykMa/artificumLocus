package com.example.artificumlocus.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.artificumlocus.databinding.FragmentOffertListBinding
import com.example.artificumlocus.databinding.FragmentSimpleOffertListBinding
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.models.OfferListViewModel
import com.example.artificumlocus.models.utilites.InjectorUtils
import com.example.artificumlocus.views.adapters.OfferAdapter

class ObservedOfferFragment : Fragment() {
    private val viewModel: OfferListViewModel by viewModels {
        InjectorUtils.provideOfferListViewModelFactory(requireContext())
    }
    lateinit var binding : FragmentSimpleOffertListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSimpleOffertListBinding.inflate(inflater, container, false)
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
            if (offers != null) {
                adapter.submitList(offers)
            }

        }

    }


}