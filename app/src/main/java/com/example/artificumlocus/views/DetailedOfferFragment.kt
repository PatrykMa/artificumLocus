package com.example.artificumlocus.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.example.artificumlocus.databinding.FragmentDetailedOfferBinding
import com.example.artificumlocus.models.models.DetailedOfferViewModel
import com.example.artificumlocus.models.utilites.InjectorUtils

class DetailedOfferFragment:Fragment() {
    private val args: DetailedOfferFragmentArgs by navArgs()
    private val viewModel: DetailedOfferViewModel by viewModels {
        InjectorUtils.provideDetailedOfferViewModelFactory(requireContext())
    }
    lateinit var binding : FragmentDetailedOfferBinding
    private var checkScrollingUp = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailedOfferBinding.inflate(inflater, container, false)
        context ?: return binding.root
        viewModel.setID(args.offertId)
        setHasOptionsMenu(true)
        subscribeUi()
        return binding.root
    }

    private fun subscribeUi() {
        viewModel.offer.observe(viewLifecycleOwner) { offer ->
            /**
             *  Plant may return null, but the [observe] extension function assumes it will not be null.
             *  So there will be a warning（Condition `departures != null` is always `true`） here.
             *  I am not sure if the database return data type should be defined as nullable, Such as `LiveData<List<Plant>?>` .
             */
            if (offer != null) {
                binding.offer = offer;
                binding.imageView3.setImageBitmap(offer.bitmap)
                binding.invalidateAll()

            }

        }
    }
}