package com.example.artificumlocus.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.example.artificumlocus.R
import com.example.artificumlocus.databinding.FragmentAddOffertBinding
import com.example.artificumlocus.databinding.FragmentOffertListBinding
import com.example.artificumlocus.models.data.Address
import com.example.artificumlocus.models.models.OfferListViewModel
import com.example.artificumlocus.models.utilites.InjectorUtils
import com.example.artificumlocus.views.adapters.OfferAdapter


class AddProductFragment : Fragment() {
    //private val viewModel: OfferListViewModel by viewModels {
    //    InjectorUtils.provideOfferListViewModelFactory(requireContext())
    //}
    lateinit var binding : FragmentAddOffertBinding
    private var checkScrollingUp = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddOffertBinding.inflate(inflater, container, false)
        context ?: return binding.root


        val adapter = OfferAdapter()
        binding.floatingActionButtonAdd.setOnClickListener {
            Log.d("TODO","add adding offert")
            findNavController().navigate(R.id.action_addProductFragment_to_offertList)
        }


        setHasOptionsMenu(true)
        return binding.root
    }

}
